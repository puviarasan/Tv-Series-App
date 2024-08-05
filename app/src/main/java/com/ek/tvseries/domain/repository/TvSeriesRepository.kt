package com.ek.tvseries.domain.repository

import com.ek.tvseries.data.remote.dto.TvSeriesDetailDto
import com.ek.tvseries.data.remote.dto.TvSeriesListDto

interface TvSeriesRepository {
    suspend fun getPopularTvSeries(): TvSeriesListDto
    suspend fun getTvSeriesDetail(seriesId: Int): TvSeriesDetailDto
}