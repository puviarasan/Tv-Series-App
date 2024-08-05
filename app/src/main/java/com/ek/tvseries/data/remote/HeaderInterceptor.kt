package com.ek.tvseries.data.remote

import com.ek.tvseries.common.Constants.API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val headers = chain.request().newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", API_KEY)
            .build()
        return chain.proceed(headers)
    }
}