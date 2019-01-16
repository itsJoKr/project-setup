package com.example.jokr.propermock.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jokr.propermock.R
import com.example.jokr.propermock.dagger.LazyInjection
import com.example.jokr.propermock.dagger.ViewModelInjection
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @field:ViewModelInjection
    lateinit var vm: LazyInjection<MainViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        vm.get().races.observe(this, Observer {
            it?.let { races ->
                raceText.text = races.first().circuitName
            }
        })

    }


}
