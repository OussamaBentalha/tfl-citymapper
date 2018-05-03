package com.android.sam.citymapper.ui.station

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.sam.citymapper.R
import com.android.sam.citymapper.ui.models.StationViewModel

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class StationAdapter(private val stations: MutableList<StationViewModel>,
                     private val listener: StationHolder.Listener) :
        RecyclerView.Adapter<StationHolder>() {

    override fun onBindViewHolder(holder: StationHolder, position: Int) {
        holder.bindData(stations[position])
    }

    override fun getItemCount(): Int = stations.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationHolder =
        StationHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.stations_item_list, parent, false), listener)

    fun updateItemForPosition(position: Int, item: StationViewModel) {
        stations[position] = item
        notifyItemChanged(position)
    }

}