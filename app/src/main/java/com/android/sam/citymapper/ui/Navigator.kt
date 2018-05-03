package com.android.sam.citymapper.ui

import android.app.Fragment

/**
 * Created by oussamabentalha on 03/05/2018.
 */
interface Navigator {
    fun displayAndSetRootFragment(fragment: Fragment)
    fun onBackPressed() : Boolean
    fun displayStation()
    fun displayDetails()
}