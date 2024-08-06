package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ek.tvseries.domain.model.SeriesDetailModel

@Composable
fun GenreList(seriesDetail: SeriesDetailModel) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        seriesDetail.genre.forEach {
            item {
                Chip(text = it)
            }
        }
    }
}