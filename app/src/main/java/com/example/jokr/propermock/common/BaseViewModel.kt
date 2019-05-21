package com.example.jokr.propermock.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import androidx.lifecycle.viewModelScope

open class BaseViewModel: ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val job = Job()


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}