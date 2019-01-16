package com.example.jokr.propermock.dagger.mock

import com.example.jokr.propermock.ProperMockApp
import com.example.jokr.propermock.dagger.AppComponent

class MockedMockApp: ProperMockApp() {

    override fun initializeAppComponent() {
        val mockAppComponent =  DaggerMockAppComponent.builder().application(this).build()
        appComponent = mockAppComponent
        appComponent.inject(this)
    }


}