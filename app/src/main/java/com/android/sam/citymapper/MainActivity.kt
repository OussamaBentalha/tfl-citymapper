package com.android.sam.citymapper

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.android.sam.citymapper.data.tfl.TflApi
import com.android.sam.citymapper.data.tfl.services.StopPointsService
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.ActivityInjector
import com.github.salomonbrys.kodein.instance
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : Activity(), ActivityInjector {

    override val injector: KodeinInjector = KodeinInjector()

    private val tflApi: TflApi by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        tflApi.getNearbyStations("51.5267869", "-0.045426").subscribeOn(AndroidSchedulers.mainThread())
                .subscribe( { result -> Toast.makeText(this, result.size, Toast.LENGTH_SHORT).show() })
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyInjector()
    }
}
