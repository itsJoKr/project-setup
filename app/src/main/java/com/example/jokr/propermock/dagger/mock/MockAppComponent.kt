package com.example.jokr.propermock.dagger.mock

import com.example.jokr.propermock.ProjectApp
import com.example.jokr.propermock.dagger.AppComponent
import com.example.jokr.propermock.dagger.modules.ActivityInjectorsModule
import com.example.jokr.propermock.dagger.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MockApiModule::class,
        ActivityInjectorsModule::class,
        NetworkModule::class
    ]
)
interface MockAppComponent: AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: ProjectApp): Builder

        fun build(): MockAppComponent
    }

}