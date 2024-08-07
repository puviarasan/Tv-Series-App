package com.ek.tvseries.data.mappers

import com.ek.tvseries.data.remote.dto.SeriesDetail
import com.ek.tvseries.domain.model.TvSeriesListModel

fun SeriesDetail.toTvSeriesModel(): TvSeriesListModel {
    return TvSeriesListModel(
        name = name,
        overView = overview,
        imageUrl = posterPath,
        seriesId = id
    )
}