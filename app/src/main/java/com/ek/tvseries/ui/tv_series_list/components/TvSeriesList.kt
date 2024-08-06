package com.ek.tvseries.ui.tv_series_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ek.tvseries.domain.model.TvSeriesListState
import com.ek.tvseries.ui.Screen

@Composable
fun TvSeriesList(
    padding: PaddingValues,
    state: TvSeriesListState,
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = padding.calculateTopPadding())
    ) {
        items(state.tvSeries) { tvSeries ->
            TvSeriesItem(tvSeries = tvSeries, onItemClick = {
                navController.navigate(Screen.TvSeriesDetailScreen.route + "/${tvSeries.seriesId}")
            })
        }
    }
}