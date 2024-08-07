package com.ek.tvseries.domain.use_case.get_series_list

import com.ek.tvseries.common.Resource
import com.ek.tvseries.data.mappers.toTvSeriesList
import com.ek.tvseries.domain.model.TvSeriesListModel
import com.ek.tvseries.domain.repository.TvSeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSeriesListUseCase @Inject constructor(private val repository: TvSeriesRepository){
     operator fun invoke(): Flow<Resource<List<TvSeriesListModel>>> = flow {
         try {
            emit(Resource.Loading())
             val tvSeriesData = repository.getPopularTvSeries().toTvSeriesList()
             emit(Resource.Success(tvSeriesData))
         }
         catch (e: HttpException){
             emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
         }
         catch (e: IOException){
             emit(Resource.Error("Couldn't reach server. Check your internet connection"))
         }
     }

}