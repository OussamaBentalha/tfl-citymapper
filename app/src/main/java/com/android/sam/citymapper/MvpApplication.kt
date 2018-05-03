package com.android.sam.citymapper

import android.app.Application
import android.content.Context
import com.android.sam.citymapper.data.dataKodeinModule
import com.android.sam.citymapper.ui.uiKodeinModule
import com.github.salomonbrys.kodein.*

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class MvpApplication : Application(), KodeinAware {
    override val kodein: Kodein by Kodein.lazy {
        bind<Context>("applicationContext") with instance(applicationContext)
        import(dataKodeinModule)
        import(uiKodeinModule)
    }

}