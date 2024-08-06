package com.ek.tvseries.ui.tv_series_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ek.tvseries.common.Resource
import com.ek.tvseries.domain.model.TvSeriesListState
import com.ek.tvseries.domain.use_case.get_series_list.GetSeriesListUseCase
import com.ek.tvseries.domain.use_case.search_tv_series.SearchTvSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TvSeriesViewmodel @Inject constructor(
    private val getSeriesListUseCase: GetSeriesListUseCase,
    private val searchTvSeriesUseCase: SearchTvSeriesUseCase
) : ViewModel() {
    private val _tvSeriesState = mutableStateOf(TvSeriesListState())
    val tvSeriesState: State<TvSeriesListState> = _tvSeriesState

    init {
        getTvSeries()
    }

    fun getTvSeries() {
        getSeriesListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _tvSeriesState.value = TvSeriesListState(
                        tvSeries = result.data ?: emptyList(),
                        isRefreshing = false
                    )
                }

                is Resource.Error -> {
                    _tvSeriesState.value =
                        TvSeriesListState(
                            error = result.message ?: "An unexpected error occurred",
                            isRefreshing = false
                        )
                }

                is Resource.Loading -> {
                    _tvSeriesState.value = TvSeriesListState(isLoading = true, isRefreshing = false)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onSearchQueryChanged(query: String) {
        _tvSeriesState.value = _tvSeriesState.value.copy(searchQuery = query)
    }

    fun searchSeries() {
        searchTvSeriesUseCase(_tvSeriesState.value.searchQuery).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _tvSeriesState.value = TvSeriesListState(tvSeries = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _tvSeriesState.value =
                        TvSeriesListState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _tvSeriesState.value = TvSeriesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}