package com.ek.tvseries.domain.use_case.get_series_details

import com.ek.tvseries.common.Resource
import com.ek.tvseries.data.mappers.toSeriesDetail
import com.ek.tvseries.domain.model.SeriesDetailModel
import com.ek.tvseries.domain.repository.TvSeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSeriesDetailUseCase @Inject constructor(private val repository: TvSeriesRepository) {
    operator fun invoke(seriesId: Int): Flow<Resource<SeriesDetailModel>> = flow {
        try {
            emit(Resource.Loading())
            val seriesDetail = repository.getTvSeriesDetail(seriesId).toSeriesDetail()
            emit(Resource.Success(seriesDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

}