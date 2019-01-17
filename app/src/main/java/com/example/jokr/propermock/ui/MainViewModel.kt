package com.example.jokr.propermock.ui

import android.arch.lifecycle.MutableLiveData
import com.example.jokr.propermock.common.BaseViewModel
import com.example.jokr.propermock.models.Races
import com.example.jokr.propermock.repositories.RacesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val racesRepository: RacesRepository
): BaseViewModel() {

    val races = MutableLiveData<Races>()

    init {
        fetchRaces()
    }

    private fun fetchRaces() {
        launch(coroutineContext) {
            val response = racesRepository.getRaces().await()
            races.postValue(response)
        }
    }
}