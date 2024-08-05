package com.ek.tvseries.ui.tv_series_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ek.tvseries.common.Constants
import com.ek.tvseries.common.Resource
import com.ek.tvseries.domain.model.SeriesDetailState
import com.ek.tvseries.domain.model.TvSeriesListState
import com.ek.tvseries.domain.use_case.get_series_details.GetSeriesDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TvSeriesDetailViewmodel @Inject constructor(
    private val getSeriesDetailUseCase: GetSeriesDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _tvSeriesDetailState = mutableStateOf(SeriesDetailState())
    val tvSeriesState: State<SeriesDetailState> = _tvSeriesDetailState

    init {
        savedStateHandle.get<String>(Constants.PARAM_SERIES_ID)?.let { tvSeriesId ->
            getSeriesDetails(tvSeriesId)
        }
    }

    private fun getSeriesDetails(tvSeriesId: String) {
        getSeriesDetailUseCase(tvSeriesId.toInt()).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _tvSeriesDetailState.value = SeriesDetailState(seriesDetail = result.data)
                }

                is Resource.Error -> {
                    _tvSeriesDetailState.value =
                        SeriesDetailState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _tvSeriesDetailState.value = SeriesDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}