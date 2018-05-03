package com.android.sam.citymapper.data.tfl

import com.android.sam.citymapper.data.tfl.models.Arrival
import com.android.sam.citymapper.data.tfl.models.StopPointResponse
import com.android.sam.citymapper.data.tfl.services.StopPointsService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class TflApiImpl(private val stopPointsService: StopPointsService) : TflApi {

    override fun getNearbyStations(lat: String, lon: String): Single<List<StopPointResponse>> {
        return stopPointsService.getByGeoPoint("1000", "NaptanMetroStation", lat, lon)
                .subscribeOn(Schedulers.io())
                .flatMap { Single.just(it.stopPoints) }

    }

    override fun getNextArrivals(stationId: String): Single<List<Arrival>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}