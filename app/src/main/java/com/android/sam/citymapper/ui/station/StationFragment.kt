package com.android.sam.citymapper.ui.station

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.sam.citymapper.R
import com.android.sam.citymapper.ui.models.StationViewModel
import com.android.sam.kotlin_mvp_project.mvp.BaseMvpFragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.FragmentInjector
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.fragment_stations.*

/**
 * Created by oussamabentalha on 03/05/2018.
 */
class StationFragment : BaseMvpFragment<StationContract.View, StationPresenter>(), StationContract.View, FragmentInjector, StationHolder.Listener {

    override val injector: KodeinInjector = KodeinInjector()

    override val mPresenter: StationPresenter by instance()

    val defaultLayout: Int = R.layout.fragment_stations

    lateinit var adapter: StationAdapter

    override fun provideOverridingModule() = Kodein.Module {
        bind<StationContract.View>() with instance(this@StationFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(defaultLayout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.fetchStation()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun setData(episodes: List<StationViewModel>) {
        adapter = StationAdapter(episodes.toMutableList(), this)
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = adapter
    }

    override fun updateItemAtPosition(item: StationViewModel, position: Int) {
        adapter.updateItemForPosition(position, item)
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onClickItems(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyInjector()
    }

}