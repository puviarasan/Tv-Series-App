package com.ek.tvseries.data.remote.dto


import com.ek.tvseries.domain.model.TvSeriesListModel
import com.google.gson.annotations.SerializedName

data class TvSeriesListDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val seriesDetails: List<SeriesDetail>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

fun TvSeriesListDto.toTvSeriesList(): List<TvSeriesListModel> {
    return seriesDetails.filter { it.name.isNotEmpty() && it.overview.isNotEmpty() }
        .map { it.toTvSeriesModel() }
}


