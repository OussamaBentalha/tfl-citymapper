package com.android.sam.citymapper.ui

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import com.android.sam.citymapper.ui.station.StationFragment

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class AppFragmentNavigator(val context: Context, val fragmentManager: FragmentManager, val containerId: Int) : Navigator {

    override fun displayAndSetRootFragment(fragment: Fragment) {
        fragmentManager
                .beginTransaction()
                .add(containerId, fragment)
                .commit()
    }

    override fun onBackPressed(): Boolean {
        return true;
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayStation() {
        var fragment = StationFragment()
        displayAndSetRootFragment(fragment)
    }

    override fun displayDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}