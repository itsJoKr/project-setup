package com.example.jokr.propermock.common.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Observe on [LiveData] & return only not null values
 */
fun <T> LiveData<T>.safeObserve(owner: LifecycleOwner, listener: (T) -> Unit) {
    observe(owner, Observer { value ->
        value?.let { listener(it) }
    })
}