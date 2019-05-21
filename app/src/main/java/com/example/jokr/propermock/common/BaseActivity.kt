package com.example.jokr.propermock.common

import android.os.Bundle
import com.example.jokr.propermock.common.extensions.render
import com.example.jokr.propermock.common.extensions.safeObserve
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<State: Any, Event: Any> : DaggerAppCompatActivity(), ViewModelObserver {


    abstract fun provideViewModel(): BaseViewModel<State, Event>?

    abstract fun handleState(state: State)

    abstract fun handleEvent(event: Event)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        provideViewModel()?.viewStateRender()?.render(this) { state -> handleState(state) }
        provideViewModel()?.viewEventHandler()?.safeObserve(this) { event -> handleEvent(event) }
    }

}