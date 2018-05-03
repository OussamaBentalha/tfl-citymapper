package com.android.sam.citymapper.data.tfl

import com.android.sam.citymapper.data.tfl.models.Arrival
import com.android.sam.citymapper.data.tfl.models.StopPointResponse
import com.android.sam.citymapper.data.tfl.models.StopPointsResponse
import io.reactivex.Single

/**
 * Created by oussamabentalha on 03/05/2018.
 */
interface TflApi {
    fun getNearbyStations(lat: String, lon: String): Single<List<StopPointResponse>>
    fun getNextArrivals(stationId: String) : Single<List<Arrival>>
}