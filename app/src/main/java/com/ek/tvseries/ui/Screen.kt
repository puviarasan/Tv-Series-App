package com.ek.tvseries.ui

sealed class Screen(val route: String) {
    object TvSeriesListScreen : Screen("tv_series_list_screen")
    object TvSeriesDetailScreen : Screen("tv_series_detail_screen")

}