package com.example.jokr.propermock.dagger

import com.example.jokr.propermock.ProjectApp
import com.example.jokr.propermock.dagger.modules.ActivityInjectorsModule
import com.example.jokr.propermock.dagger.modules.ApiModule
import com.example.jokr.propermock.dagger.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApiModule::class,
        ActivityInjectorsModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: ProjectApp): Builder

        fun build(): AppComponent
    }

    fun inject(formulaEApplication: ProjectApp)
}