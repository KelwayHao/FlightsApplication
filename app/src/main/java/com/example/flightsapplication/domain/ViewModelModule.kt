package com.example.flightsapplication.domain

import com.example.flightsapplication.presentation.viewmodel.FlightViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        FlightViewModel(
            get()
        )
    }
}