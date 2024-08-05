package com.ek.tvseries.di

import com.ek.tvseries.common.Constants.BASE_URL
import com.ek.tvseries.data.remote.HeaderInterceptor
import com.ek.tvseries.data.remote.TvSeriesApi
import com.ek.tvseries.data.repository.TvSeriesRepositoryImpl
import com.ek.tvseries.domain.repository.TvSeriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesTvSeriesApi(headerInterceptor: HeaderInterceptor): TvSeriesApi {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(TvSeriesApi::class.java)
    }

    @Provides
    @Singleton
    fun providesTvSeriesRepository(api: TvSeriesApi): TvSeriesRepository {
        return TvSeriesRepositoryImpl(api)
    }
}