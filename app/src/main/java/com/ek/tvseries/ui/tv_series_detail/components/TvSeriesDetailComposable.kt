package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ek.tvseries.ui.common_components.TvAppBar
import com.ek.tvseries.ui.tv_series_detail.TvSeriesDetailViewmodel

@Composable
fun TvSeriesDetailComposable(viewmodel: TvSeriesDetailViewmodel = hiltViewModel()) {
    val state = viewmodel.tvSeriesState.value
    val seasonDetailState = viewmodel.seasonDetailState.value
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = { state.seriesDetail?.name?.let { TvAppBar(name = it) } }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
                .verticalScroll(scrollState)
        ) {
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            if (state.isLoading.not() && state.error.isBlank()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    SeriesHeaderComposable(state)
                    if (state.seriesDetail?.genre?.isNotEmpty() == true) {
                        Text(
                            text = "Genre",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        GenreList(state.seriesDetail)

                    }
                    if (state.seriesDetail?.numberOfSeasons!! > 0) {
                        SeasonsDropDown(seasonDetailState, state.seriesDetail.numberOfSeasons)
                        EpisodesListComposable(seasonDetailState)
                        CastList(
                            castDetailsList = seasonDetailState.seasonDetail?.crewDetails
                                ?: emptyList(), "Crew"
                        )
                        CastList(
                            castDetailsList = seasonDetailState.seasonDetail?.castDetails
                                ?: emptyList(), "Cast"
                        )
                    }
                }
            }
        }
    }
}

