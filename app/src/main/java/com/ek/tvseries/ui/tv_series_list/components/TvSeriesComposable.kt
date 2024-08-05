package com.ek.tvseries.ui.tv_series_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ek.tvseries.ui.Screen
import com.ek.tvseries.ui.tv_series_list.TvSeriesViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvSeriesComposable(
    navController: NavController,
    tvSeriesViewmodel: TvSeriesViewmodel = hiltViewModel()
) {
    val state = tvSeriesViewmodel.tvSeriesState.value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Popular TV Series") })
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = it.calculateTopPadding())
            ) {
                items(state.tvSeries) { tvSeries ->
                    TvSeriesItem(tvSeries = tvSeries, onItemClick = {
                        navController.navigate(Screen.TvSeriesDetailScreen.route + "/${tvSeries.seriesId}")
                    })
                }
            }
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
        }
    }
}