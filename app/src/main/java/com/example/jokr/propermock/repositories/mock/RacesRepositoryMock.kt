package com.example.jokr.propermock.repositories.mock

import com.example.jokr.propermock.Mockaroo
import com.example.jokr.propermock.models.Race
import com.example.jokr.propermock.models.Races
import com.example.jokr.propermock.repositories.RacesRepository
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class RacesRepositoryMock @Inject constructor(
    private val mockaroo: Mockaroo
) : RacesRepository {

    inline fun <reified T> genericType() = object : TypeToken<T>() {}.type

    override fun getRaces(): Deferred<Races> {
        val races = mockaroo.getApiResponse<Races>("races.json", genericType<Races>())
        return GlobalScope.async { races }
    }
}