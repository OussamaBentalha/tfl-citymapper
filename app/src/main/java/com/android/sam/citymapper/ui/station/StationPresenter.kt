package com.android.sam.citymapper.ui.station

import com.android.sam.citymapper.data.tfl.TflApi
import com.android.sam.citymapper.data.tfl.models.StopPointResponse
import com.android.sam.citymapper.ui.Navigator
import com.android.sam.citymapper.ui.models.StationViewModel
import com.android.sam.kotlin_mvp_project.mvp.BaseMvpPresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class StationPresenter(val view: StationContract.View,
                       val navigator: Navigator,
                       val tflApi: TflApi) : BaseMvpPresenterImpl<StationContract.View>(), StationContract.Presenter {

    lateinit var stationViewModels:MutableList<StationViewModel>


    override fun checkLocation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchStation() {
        tflApi.getNearbyStations("51.5267869", "-0.045426").repeat(30000)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( { result -> subscriberFetchStation(result)
                     })
    }

    fun subscriberFetchStation(result: List<StopPointResponse>){
        stationViewModels = apiDataConverter(result).toMutableList()
        view.setData(stationViewModels)
    }

    override fun fetchDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     *  *
     *  ApiModel and ViewModel used here
     */
    private fun apiDataConverter(response: List<StopPointResponse>): List<StationViewModel> {
        return response.flatMap {
            val mutableList = mutableListOf<StationViewModel>()

            response.forEach { station ->
                mutableList.add(StationViewModel(station.id, station.commonName, ""))
            }

            return mutableList
        }
    }

}