package com.example.jokr.propermock.repositories

import com.example.jokr.propermock.dagger.modules.ApiService
import com.example.jokr.propermock.models.Races
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class RacesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): RacesRepository {

    override fun getRaces(): Deferred<Races> {
        return apiService.getRaces()
    }
}
