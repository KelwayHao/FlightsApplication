package com.example.flightsapplication

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FlightApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FlightApplication)
            modules(
                listOf(

                )
            )
        }
    }
}