package com.android.sam.citymapper.data

import com.android.sam.citymapper.data.tfl.tflModule
import com.github.salomonbrys.kodein.Kodein

/**
 * Created by oussamabentalha on 03/05/2018.
 */
val dataKodeinModule = Kodein.Module {
    import(tflModule)
}