package com.example.jokr.propermock.dagger.mock

import com.example.jokr.propermock.repositories.RacesRepository
import com.example.jokr.propermock.repositories.RacesRepositoryImpl
import com.example.jokr.propermock.repositories.mock.RacesRepositoryMock
import dagger.Module
import dagger.Provides

@Module
class MockApiModule {

    @Provides
    fun provideApplication(repo: RacesRepositoryMock): RacesRepository = repo

}