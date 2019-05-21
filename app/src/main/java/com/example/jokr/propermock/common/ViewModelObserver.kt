package com.example.jokr.propermock.common

import android.util.Log
import androidx.lifecycle.Observer

interface ViewModelObserver {

    fun handleCommonState(commonState: CommonState)
}

class ViewStateObserver<State : Any>(
    private val observer: ViewModelObserver,
    val action: (State) -> Unit
) : Observer<ViewState<State>> {

    private var lastState: State? = null
    private var lastCommonState: CommonState = CommonState()

    override fun onChanged(viewStateData: ViewState<State>?) {
        if (viewStateData == null) {
            Log.e("LiveData","LiveData.value is [NULL]")
            return
        }

        if (viewStateData.commonState != lastCommonState) {
            lastCommonState = viewStateData.commonState
            observer.handleCommonState(viewStateData.commonState)
        }

        if (viewStateData.viewState != null && viewStateData.viewState != lastState) {
            lastState = viewStateData.viewState
            action(viewStateData.viewState)
        }
    }
}