package com.example.jokr.propermock

import android.app.Activity
import android.app.Application
import com.example.jokr.propermock.dagger.AppComponent
import com.example.jokr.propermock.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class ProjectApp: Application(), HasActivityInjector {


    lateinit var appComponent: AppComponent

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        initializeAppComponent()
    }

    protected open fun initializeAppComponent() {
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }
}