package com.ek.tvseries.ui.tv_series_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ek.tvseries.ui.common_components.TvAppBar
import com.ek.tvseries.ui.tv_series_list.TvSeriesViewmodel

@Composable
fun TvSeriesComposable(
    navController: NavController,
    tvSeriesViewmodel: TvSeriesViewmodel = hiltViewModel()
) {
    val state = tvSeriesViewmodel.tvSeriesState.value
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        topBar = { TvAppBar(name = "TV Series") }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding())
        ) {
            SeriesSearchBar(state, tvSeriesViewmodel, keyboardController, focusManager)
            TvSeriesList(it, state, navController)
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
