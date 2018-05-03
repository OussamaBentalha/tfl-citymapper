package com.android.sam.citymapper.ui.station

import com.android.sam.citymapper.ui.models.StationViewModel
import com.android.sam.kotlin_mvp_project.mvp.BaseMvpPresenter
import com.android.sam.kotlin_mvp_project.mvp.BaseMvpView

/**
 * Created by oussamabentalha on 03/05/2018.
 */
interface StationContract {
    interface View : BaseMvpView {
        fun setData(episodes: List<StationViewModel>)
        fun updateItemAtPosition(item: StationViewModel, position: Int)
        fun showErrorMessage(message: String)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun checkLocation()
        fun fetchStation()
        fun fetchDetails()
    }
}