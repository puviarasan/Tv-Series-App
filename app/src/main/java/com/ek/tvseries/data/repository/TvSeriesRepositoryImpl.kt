package com.ek.tvseries.data.repository

import com.ek.tvseries.data.remote.TvSeriesApi
import com.ek.tvseries.data.remote.dto.SeasonDetailDto
import com.ek.tvseries.data.remote.dto.TvSeriesDetailDto
import com.ek.tvseries.data.remote.dto.TvSeriesListDto
import com.ek.tvseries.domain.repository.TvSeriesRepository
import javax.inject.Inject

class TvSeriesRepositoryImpl @Inject constructor(private val api: TvSeriesApi) :
    TvSeriesRepository {
    override suspend fun getPopularTvSeries(): TvSeriesListDto {
        return api.getPopularTvSeries()
    }

    override suspend fun getTvSeriesDetail(seriesId: Int): TvSeriesDetailDto {
        return api.getTvSeriesDetail(seriesId)
    }

    override suspend fun getSeasonDetail(seriesId: Int, seasonNumber: Int): SeasonDetailDto {
        return api.getSeasonDetail(seriesId, seasonNumber)
    }

}