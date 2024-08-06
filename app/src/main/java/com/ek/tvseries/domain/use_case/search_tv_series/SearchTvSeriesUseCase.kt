package com.ek.tvseries.domain.use_case.search_tv_series

import com.ek.tvseries.common.Resource
import com.ek.tvseries.data.remote.dto.toTvSeriesList
import com.ek.tvseries.domain.model.TvSeriesListModel
import com.ek.tvseries.domain.repository.TvSeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchTvSeriesUseCase @Inject constructor(private val repository: TvSeriesRepository) {
    operator fun invoke(query: String): Flow<Resource<List<TvSeriesListModel>>> = flow {
        try {
            emit(Resource.Loading())
            val seriesDetail = repository.searchTvSeries(query).toTvSeriesList()
            emit(Resource.Success(seriesDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}