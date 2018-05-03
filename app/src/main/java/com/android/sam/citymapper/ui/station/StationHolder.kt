package com.android.sam.citymapper.ui.station

import android.support.v7.widget.RecyclerView
import android.view.View
import com.android.sam.citymapper.ui.models.StationViewModel
import kotlinx.android.synthetic.main.stations_item_list.view.*

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class StationHolder(val view: View, val listener: Listener) : RecyclerView.ViewHolder(view) {

    fun bindData(data: StationViewModel){
        view.stationName.text = data.stationName
        /*view.firstNextArrival.text =
        view.secondNextArrival.text =
        view.thirdNextArrival.text =*/

        view.setOnClickListener{ listener.onClickItems(adapterPosition) }
    }

    interface Listener {
        fun onClickItems(position: Int)
    }
}