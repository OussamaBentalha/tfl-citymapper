package com.android.sam.citymapper

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.android.sam.citymapper.data.tfl.TflApi
import com.android.sam.citymapper.data.tfl.services.StopPointsService
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.ActivityInjector
import com.github.salomonbrys.kodein.instance
import io.reactivex.android.schedulers.AndroidSchedulers
import android.location.LocationManager
import android.content.Context.LOCATION_SERVICE
import com.android.sam.citymapper.ui.AppFragmentNavigator
import com.android.sam.citymapper.ui.Navigator
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind


class MainActivity : Activity(), ActivityInjector {

    override val injector: KodeinInjector = KodeinInjector()

    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = AppFragmentNavigator(this, this.fragmentManager, R.id.fragment_container)
        initializeInjector()
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<Navigator>() with instance(navigator)
    }

    override fun onResume() {
        super.onResume()
        navigator.displayStation()

        /*val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        val longitude = location.longitude
        val latitude = location.latitude*/
    }

    override fun onBackPressed() {
        val handled = navigator.onBackPressed()

        if (!handled) {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyInjector()
    }
}
