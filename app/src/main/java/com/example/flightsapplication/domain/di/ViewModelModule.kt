package com.example.flightsapplication.domain.di

import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import com.example.flightsapplication.presentation.viewmodel.HistoryFragmentViewModel
import com.example.flightsapplication.presentation.viewmodel.FlightFragmentViewModel
import com.example.flightsapplication.utils.resourceprovider.ResourceProvider
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideFlightFragmentViewModel(
        interactor: FlightTicketInteractor,
        resourceProvider: ResourceProvider
    ) : FlightFragmentViewModel {
        return FlightFragmentViewModel (interactor, resourceProvider)
    }

    @Provides
    fun provideHistoryFragmentViewModel(
        interactor: FlightTicketInteractor,
        resourceProvider: ResourceProvider
    ) : HistoryFragmentViewModel {
        return HistoryFragmentViewModel(interactor, resourceProvider)
    }
}
