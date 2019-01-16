package com.example.jokr.propermock.dagger.modules

import com.example.jokr.propermock.ui.MainActivity
import com.example.jokr.propermock.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

//Compiler doesn't see Injector methods, but they're used by Dagger using code generation:
@Suppress("unused")
@Module
abstract class ActivityInjectorsModule {

    @ContributesAndroidInjector(
        modules = [MainModule::class])
    abstract fun mainActivityInjector(
    ): MainActivity

}