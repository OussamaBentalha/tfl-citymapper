package com.android.sam.citymapper.data.tfl

import com.android.sam.citymapper.data.tfl.services.StopPointsService
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * Created by oussamabentalha on 03/05/2018.
 */
val tflModule = Kodein.Module {
    bind<OkHttpClient>() with singleton { buildBetaSeriesHttpClient() }
    bind<Retrofit>() with singleton { buildBetaSeriesRetrofit(instance()) }
    bind<StopPointsService>() with singleton { buildStopPointsEndpoint(instance()) }
    bind<TflApi>() with singleton { TflApiImpl(instance()) }
}