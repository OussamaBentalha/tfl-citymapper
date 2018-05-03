package com.android.sam.citymapper.data.tfl

import com.android.sam.citymapper.data.tfl.services.StopPointsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by oussamabentalha on 03/05/2018.
 */
fun buildBetaSeriesHttpClient(): OkHttpClient {
    val logInterceptor = HttpLoggingInterceptor()
    logInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .addInterceptor(TflHeaderInterceptor())
            .build()
}

fun buildBetaSeriesRetrofit(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://api.tfl.gov.uk/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

fun buildStopPointsEndpoint(retrofit: Retrofit): StopPointsService {
    return retrofit.create(StopPointsService::class.java)
}