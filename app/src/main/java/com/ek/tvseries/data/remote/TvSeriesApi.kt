package com.ek.tvseries.data.remote

import com.ek.tvseries.data.remote.dto.SeasonDetailDto
import com.ek.tvseries.data.remote.dto.TvSeriesDetailDto
import com.ek.tvseries.data.remote.dto.TvSeriesListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvSeriesApi {
    @GET("3/tv/popular")
    suspend fun getPopularTvSeries(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): TvSeriesListDto

    @GET("3/tv/{series_id}")
    suspend fun getTvSeriesDetail(
        @Path("series_id") seriesId: Int,
        @Query("language") language: String = "en-US"
    ): TvSeriesDetailDto

    @GET("3/tv/{series_id}/season/{season_number}")
    suspend fun getSeasonDetail(
        @Path("series_id") seriesId: Int,
        @Path("season_number") seasonNumber: Int,
        @Query("language") language: String = "en-US"
    ): SeasonDetailDto

}