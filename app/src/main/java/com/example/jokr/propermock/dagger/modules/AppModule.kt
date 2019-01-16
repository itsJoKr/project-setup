package com.example.jokr.propermock.dagger.modules

import android.content.Context
import com.example.jokr.propermock.ProperMockApp
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideApplication(formulaEApplication: ProperMockApp): Context = formulaEApplication
}

/** `Dagger2` qualifier that describes a [android.content.Context]
 * instance as an application context.  */
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext