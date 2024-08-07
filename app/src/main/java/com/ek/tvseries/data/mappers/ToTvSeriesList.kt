package com.ek.tvseries.data.mappers

import com.ek.tvseries.data.remote.dto.TvSeriesListDto
import com.ek.tvseries.domain.model.TvSeriesListModel

fun TvSeriesListDto.toTvSeriesList(): List<TvSeriesListModel> {
    return seriesDetails.filter { it.name.isNotEmpty() && it.overview.isNotEmpty() }
        .map { it.toTvSeriesModel() }
}