package com.example.jokr.propermock.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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
        viewModelScope.launch {
            val response = racesRepository.getRaces().await()
            races.postValue(response)
        }
    }
}