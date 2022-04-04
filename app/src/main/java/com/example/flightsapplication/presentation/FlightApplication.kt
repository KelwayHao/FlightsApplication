package com.example.flightsapplication.presentation

import android.app.Application
import com.example.flightsapplication.data.di.dataModule
import com.example.flightsapplication.data.di.roomModule
import com.example.flightsapplication.domain.di.domainModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FlightApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FlightApplication)
            modules(
                listOf(
                    roomModule,
                    dataModule,
                    domainModelModule,
                    viewMo
                )
            )
        }
    }
}