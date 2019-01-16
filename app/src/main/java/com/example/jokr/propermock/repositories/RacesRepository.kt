package com.example.jokr.propermock.repositories

import com.example.jokr.propermock.models.Races
import kotlinx.coroutines.Deferred

interface RacesRepository {

    fun getRaces(): Deferred<Races>

}