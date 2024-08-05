package com.ek.tvseries.ui.tv_series_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ek.tvseries.common.Resource
import com.ek.tvseries.domain.model.TvSeriesListState
import com.ek.tvseries.domain.use_case.get_series_list.GetSeriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TvSeriesViewmodel @Inject constructor(
    private val getSeriesListUseCase: GetSeriesListUseCase
) : ViewModel() {
    private val _tvSeriesState = mutableStateOf(TvSeriesListState())
    val tvSeriesState: State<TvSeriesListState> = _tvSeriesState

    init {
        getTvSeries()
    }

    private fun getTvSeries() {
        getSeriesListUseCase().onEach { result ->
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