package com.example.jokr.propermock

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import android.support.test.runner.AndroidJUnitRunner
import com.example.jokr.propermock.dagger.mock.MockedProjectApp

class MockTestRunner: AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        super.onCreate(arguments)
    }

    @Throws(
        InstantiationException::class,
        IllegalAccessException::class,
        ClassNotFoundException::class
    )
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, MockedProjectApp::class.java.name, context)
    }
}