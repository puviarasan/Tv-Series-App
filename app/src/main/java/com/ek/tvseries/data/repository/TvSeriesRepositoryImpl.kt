package com.ek.tvseries.data.repository

import com.ek.tvseries.data.remote.TvSeriesApi
import com.ek.tvseries.domain.repository.TvSeriesRepository
import javax.inject.Inject

class TvSeriesRepositoryImpl @Inject constructor(private val api: TvSeriesApi) :
    TvSeriesRepository {

}