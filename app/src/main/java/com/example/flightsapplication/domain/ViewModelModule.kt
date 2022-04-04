package com.example.flightsapplication.domain

import com.example.flightsapplication.presentation.viewmodel.HistoryFragmentViewModel
import com.example.flightsapplication.presentation.viewmodel.FlightFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<FlightFragmentViewModel> {
        FlightFragmentViewModel(
            get()
        )
    }

    viewModel<HistoryFragmentViewModel> {
        HistoryFragmentViewModel(
            get()
        )
    }
}