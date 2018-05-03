package com.android.sam.citymapper.ui

import com.android.sam.citymapper.ui.detail.detailKodeinModule
import com.android.sam.citymapper.ui.station.stationKodeinModule
import com.github.salomonbrys.kodein.Kodein

/**
 * Created by oussamabentalha on 03/05/2018.
 */
val uiKodeinModule = Kodein.Module {
    import(stationKodeinModule)
    import(detailKodeinModule)
}