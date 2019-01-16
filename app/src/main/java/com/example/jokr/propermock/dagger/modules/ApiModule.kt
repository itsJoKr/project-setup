package com.example.jokr.propermock.dagger.modules

import com.example.jokr.propermock.repositories.RacesRepository
import com.example.jokr.propermock.repositories.RacesRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    fun provideApplication(repo: RacesRepositoryImpl): RacesRepository = repo

}