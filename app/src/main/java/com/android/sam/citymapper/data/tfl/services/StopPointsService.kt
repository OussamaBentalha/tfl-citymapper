package com.android.sam.citymapper.data.tfl.services

import com.android.sam.citymapper.data.tfl.models.NextArrivals
import com.android.sam.citymapper.data.tfl.models.StopPointsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by oussamabentalha on 03/05/2018.
 */
interface StopPointsService {

    @GET("StopPoint")
    fun getByGeoPoint(@Query("radius") radius: String, @Query("stopTypes") stopTypes: String, @Query("lat") lat: String, @Query("lon") lon: String): Single<StopPointsResponse>

    @GET("StopPoint/{id}/Arrivals")
    fun getNextArrivalsByStationId(@Path("id") stationId: String) : Single<NextArrivals>

}