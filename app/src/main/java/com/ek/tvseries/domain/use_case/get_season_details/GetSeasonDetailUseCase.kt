package com.ek.tvseries.domain.use_case.get_season_details

import com.ek.tvseries.common.Resource
import com.ek.tvseries.data.mappers.toSeasonDetailModel
import com.ek.tvseries.domain.model.SeasonDetailModel
import com.ek.tvseries.domain.repository.TvSeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSeasonDetailUseCase @Inject constructor(private val repository: TvSeriesRepository) {
    operator fun invoke(seriesId: Int, seasonNumber: Int): Flow<Resource<SeasonDetailModel>> =
        flow {
            try {
                emit(Resource.Loading())
                val seasonDetail =
                    repository.getSeasonDetail(seriesId, seasonNumber).toSeasonDetailModel()
                emit(Resource.Success(seasonDetail))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server. Check your internet connection"))
            }
        }
}