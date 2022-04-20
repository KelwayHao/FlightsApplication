package com.example.flightsapplication.domain

import androidx.lifecycle.ViewModel
import com.example.flightsapplication.domain.repository.FlightTicketInteractor
import com.example.flightsapplication.presentation.viewmodel.HistoryFragmentViewModel
import com.example.flightsapplication.presentation.viewmodel.FlightFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideFlightFragmentViewModel(
        interactor: FlightTicketInteractor
    ) : FlightFragmentViewModel {
        return FlightFragmentViewModel (interactor)
    }

    @Provides
    fun provideHistoryFragmentViewModel(
        interactor: FlightTicketInteractor
    ) : HistoryFragmentViewModel {
        return HistoryFragmentViewModel(interactor)
    }
}

/*val viewModelModule = module {
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
}*/