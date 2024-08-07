package com.ek.tvseries.data.mappers

import com.ek.tvseries.data.remote.dto.TvSeriesDetailDto
import com.ek.tvseries.domain.model.SeriesDetailModel

fun TvSeriesDetailDto.toSeriesDetail(): SeriesDetailModel {
    return SeriesDetailModel(
        name = name,
        image = posterPath,
        synopsis = overview,
        episodes = numberOfEpisodes.toString(),
        posterUrl = backdropPath ?: "",
        description = overview,
        genre = genres.map { it.name },
        numberOfSeasons = numberOfSeasons,
        id = id
    )
}