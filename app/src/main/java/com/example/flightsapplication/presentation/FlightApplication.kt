package com.example.flightsapplication.presentation

import android.app.Application
import com.example.flightsapplication.AppComponent
import com.example.flightsapplication.DaggerAppComponent

class FlightApplication: Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .buildContext(this)
            .build()
    }
}