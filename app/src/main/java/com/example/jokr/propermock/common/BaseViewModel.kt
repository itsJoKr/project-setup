package com.example.jokr.propermock.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State : Any, Event : Any>: ViewModel() {

    private val stateLiveData: MutableLiveData<ViewState<State>> = MutableLiveData()
    private val eventLiveData: LiveEvent<Event> = LiveEvent()

    fun viewStateRender(): LiveData<ViewState<State>> = stateLiveData
    fun viewEventHandler(): LiveData<Event> = eventLiveData

    /**
     * This method is used to set an initial state of the screen. In case where a fragment is recreated
     * and his ViewModel is not destroyed we do not want the initial screen state to be set again because
     * maybe the screen state was already in a newer state that the user wants to see after a fragments recreation.
     */
    protected fun setInitialState(initialState: State) {
        viewState = if (viewState == null) {
            initialState
        } else {
            viewState
        }
    }

    protected var viewState: State? = null
        get() = stateLiveData.value?.viewState ?: field
        set(value) {
            val viewState = stateLiveData.value
            stateLiveData.value = viewState?.copy(viewState = value) ?: ViewState(value)
        }

    protected fun emitEvent(event: Event) {
        eventLiveData.value = event
    }
}