package com.example.jokr.propermock.dagger.mock

import com.example.jokr.propermock.ProjectApp

class MockedProjectApp: ProjectApp() {

    override fun initializeAppComponent() {
        val mockAppComponent =  DaggerMockAppComponent.builder().application(this).build()
        appComponent = mockAppComponent
        appComponent.inject(this)
    }


}