package com.ek.tvseries.domain.model

data class SeriesDetailState(
    val isLoading: Boolean = false,
    val seriesDetail: SeriesDetailModel? = null,
    val error: String = ""
)
