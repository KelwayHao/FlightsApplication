package com.example.flightsapplication.domain

import com.example.flightsapplication.presentation.viewmodel.HistoryFragmentViewModel
import com.example.flightsapplication.presentation.viewmodel.RegistrationFlightFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<RegistrationFlightFragmentViewModel> {
        RegistrationFlightFragmentViewModel(
            get()
        )
    }

    viewModel<HistoryFragmentViewModel> {
        HistoryFragmentViewModel(
            get()
        )
    }
}