package com.android.sam.citymapper

import android.app.Application
import com.android.sam.citymapper.data.dataKodeinModule
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class MvpApplication : Application(), KodeinAware {
    override val kodein: Kodein by Kodein.lazy {
        import(dataKodeinModule)
    }

}