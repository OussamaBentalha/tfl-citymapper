package com.android.sam.citymapper.ui.station

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

/**
 * Created by oussamabentalha on 03/05/2018.
 */
val stationKodeinModule = Kodein.Module {
    bind<StationPresenter>() with singleton { StationPresenter(instance(), instance(), instance()) }
}