package com.android.sam.citymapper.data.tfl

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class TflHeaderInterceptor : Interceptor {

    companion object {
        private val API_ID = "ba4e8008"
        private val API_KEY = " 12dd011f6f52315ea4c10648e1c6af75"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()

        val newRequest = original.newBuilder()
                .header("app_id", API_ID)
                .header("app_key", API_KEY)
                .build()

        return chain.proceed(newRequest)
    }


}