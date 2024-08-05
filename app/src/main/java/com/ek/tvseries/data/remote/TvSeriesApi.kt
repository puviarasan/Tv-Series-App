package com.ek.tvseries.data.remote

import com.ek.tvseries.data.remote.dto.TvSeriesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TvSeriesApi {
    @GET("3/tv/popular")
    suspend fun getPopularTvSeries(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): TvSeriesListDto
}