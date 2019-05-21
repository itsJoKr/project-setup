package com.example.jokr.propermock.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jokr.propermock.R
import com.example.jokr.propermock.common.BaseActivity
import com.example.jokr.propermock.common.CommonState
import com.example.jokr.propermock.dagger.ViewModelInjection
import com.example.jokr.propermock.models.Race
import com.example.jokr.propermock.ui.detail.DetailActivity
import com.fiaformulae.formulae.common.bindings.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainState, MainEvent>() {

    override fun provideViewModel() = vm

    override fun handleState(state: MainState) {
        recycler.adapter = MainAdapter(state.races) { vm.onRaceClicked(it) }
    }

    override fun handleCommonState(commonState: CommonState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleEvent(event: MainEvent) {
        when(event) {
            is MainEvent.NavigateToDetails -> navigateToDetail(event.race)
        }
    }

    @Inject
    @field:ViewModelInjection
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    private fun navigateToDetail(race: Race) {
        startActivity<DetailActivity> {
            DetailActivity::raceArg to race
        }
    }
}
