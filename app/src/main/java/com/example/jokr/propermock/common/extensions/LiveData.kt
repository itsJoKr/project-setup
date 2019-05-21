package com.example.jokr.propermock.common.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.jokr.propermock.common.BaseActivity
import com.example.jokr.propermock.common.ViewState
import com.example.jokr.propermock.common.ViewStateObserver

/**
 * Observe on [LiveData] & return only not null values
 */
fun <T> LiveData<T>.safeObserve(owner: LifecycleOwner, listener: (T) -> Unit) {
    observe(owner, Observer { value ->
        value?.let { listener(it) }
    })
}

fun <State : Any> LiveData<ViewState<State>>.render(baseActivity: BaseActivity<*, *>, action: (State) -> Unit) {
    removeObservers(baseActivity)
    observe(baseActivity, ViewStateObserver(baseActivity, action))
}