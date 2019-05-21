package com.example.jokr.propermock.common

import androidx.annotation.MainThread
import androidx.collection.ArraySet
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/**
 * source: https://github.com/hadilq/LiveEvent/blob/master/lib/src/main/java/com/hadilq/liveevent/LiveEvent.kt
 * Based on SingleLiveEvent: https://proandroiddev.com/livedata-with-single-events-2395dea972a8
 */
class LiveEvent<T> : MediatorLiveData<T>() {

    private val observers = ArraySet<ObserverWrapper<in T>>()

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        val wrapper = ObserverWrapper(observer)
        observers.add(wrapper)
        super.observe(owner, wrapper)
    }

    @MainThread
    override fun removeObserver(observer: Observer<in T>) {
        if (!observers.remove(observer)) {
            val iterator = observers.iterator()
            while (iterator.hasNext()) {
                if (iterator.next().observer == observer) {
                    iterator.remove()
                    break
                }
            }
        }
        super.removeObserver(observer)
    }

    @MainThread
    override fun setValue(t: T?) {
        observers.forEach { it.newValue() }
        super.setValue(t)
    }

    private class ObserverWrapper<T>(val observer: Observer<T>) : Observer<T> {

        private var pending = false

        override fun onChanged(t: T?) {
            if (pending) {
                pending = false
                observer.onChanged(t)
            }
        }

        fun newValue() {
            pending = true
        }
    }
}