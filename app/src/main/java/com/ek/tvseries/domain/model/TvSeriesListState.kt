package com.ek.tvseries.domain.model

data class TvSeriesListState(
    val isLoading: Boolean = false,
    val tvSeries: List<TvSeriesListModel> = emptyList(),
    val error: String = ""
)
