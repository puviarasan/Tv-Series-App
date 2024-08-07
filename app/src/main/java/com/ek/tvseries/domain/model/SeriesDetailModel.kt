package com.ek.tvseries.domain.model

data class SeriesDetailModel (
    val id: Int,
    val name:String,
    val image:String,
    val synopsis: String,
    val episodes: String,
    val posterUrl: String?,
    val description: String,
    val genre: List<String>,
    val numberOfSeasons: Int,
)