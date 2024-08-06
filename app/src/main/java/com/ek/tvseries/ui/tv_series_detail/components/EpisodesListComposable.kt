package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ek.tvseries.domain.model.SeasonDetailState

@Composable
fun EpisodesListComposable(seasonDetailState: SeasonDetailState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (seasonDetailState.seasonDetail?.episodeDetails?.isNotEmpty() == true) {
            seasonDetailState.seasonDetail.episodeDetails.forEach {
                EpisodeListItem(episodeDetailModel = it)
            }
        }
    }

}