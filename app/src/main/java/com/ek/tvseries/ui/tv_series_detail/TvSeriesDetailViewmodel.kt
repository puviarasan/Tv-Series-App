package com.ek.tvseries.ui.tv_series_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ek.tvseries.common.Constants
import com.ek.tvseries.common.Resource
import com.ek.tvseries.domain.model.SeasonDetailState
import com.ek.tvseries.domain.model.SeriesDetailState
import com.ek.tvseries.domain.use_case.get_season_details.GetSeasonDetailUseCase
import com.ek.tvseries.domain.use_case.get_series_details.GetSeriesDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TvSeriesDetailViewmodel @Inject constructor(
    private val getSeriesDetailUseCase: GetSeriesDetailUseCase,
    private val getSeasonDetailUseCase: GetSeasonDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _tvSeriesDetailState = mutableStateOf(SeriesDetailState())
    val tvSeriesState: State<SeriesDetailState> = _tvSeriesDetailState
    private val _seasonDetailState = mutableStateOf(SeasonDetailState())
    val seasonDetailState: State<SeasonDetailState> = _seasonDetailState

    init {
        savedStateHandle.get<String>(Constants.PARAM_SERIES_ID)?.let { tvSeriesId ->
            getSeriesDetails(tvSeriesId.toInt())
        }
    }

    fun getSeriesDetails(tvSeriesId: Int) {
        getSeriesDetailUseCase(tvSeriesId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _tvSeriesDetailState.value = SeriesDetailState(seriesDetail = result.data)
                    if (result.data?.numberOfSeasons!! > 0)
                        getSeasonDetails(tvSeriesId, 1)
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

    private fun getSeasonDetails(tvSeriesId: Int, seasonNumber: Int) {
        getSeasonDetailUseCase(tvSeriesId, seasonNumber).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _seasonDetailState.value =
                        SeasonDetailState(
                            seasonDetail = result.data,
                            onSeasonSelected = { seasonNumber ->
                                getSeasonDetails(tvSeriesId, seasonNumber)
                            })
                }

                is Resource.Error -> {
                    _seasonDetailState.value = SeasonDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )

                }

                is Resource.Loading -> {
                    _seasonDetailState.value =
                        SeasonDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}