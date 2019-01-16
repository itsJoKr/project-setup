package com.example.jokr.propermock.repositories.mock

import com.example.jokr.propermock.models.Race
import com.example.jokr.propermock.models.Races
import com.example.jokr.propermock.repositories.RacesRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class RacesRepositoryMock @Inject constructor() : RacesRepository {

    override fun getRaces(): Deferred<Races> {
        return GlobalScope.async {
            return@async listOf(
                Race(
                    "de",
                    null,
                    null,
                    null,
                    "Mockito",
                    null,
                    "Mockit",
                    null,
                    1,
                    1,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
                )
            )
        }
    }
}