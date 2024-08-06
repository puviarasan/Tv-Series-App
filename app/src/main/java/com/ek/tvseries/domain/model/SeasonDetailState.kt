package com.ek.tvseries.domain.model

data class SeasonDetailState(
    val isLoading: Boolean = false,
    val seasonDetail: SeasonDetailModel? = null,
    val error: String = "",
    val onSeasonSelected: (Int) -> Unit = {}
)