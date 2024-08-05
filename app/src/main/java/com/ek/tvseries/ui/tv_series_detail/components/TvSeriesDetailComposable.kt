package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ek.tvseries.ui.tv_series_detail.TvSeriesDetailViewmodel

@Composable
fun TvSeriesDetailComposable(viewmodel: TvSeriesDetailViewmodel = hiltViewModel()) {
    val state = viewmodel.tvSeriesState.value
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = state)
    }
}
