package com.example.flightsapplication.presentation.fragment

import androidx.fragment.app.Fragment
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.viewmodel.FlightViewModel
import com.example.flightsapplication.utils.fromStringToDate
import kotlinx.android.synthetic.main.fragment_flight_registration.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RegistrationFragment : Fragment(R.layout.fragment_flight_registration) {

    companion object {
        const val TAG = "Registration fragment"
        fun newInstance() = RegistrationFragment()
    }

    private val flightViewModel: FlightViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()

        buttonConfirmFlight.setOnClickListener {
            flightViewModel.createFlightTicket(
                inputFlightDeparture.text.toString(),
                inputFlightDestination.text.toString(),
                inputDepartDate.text.toString().fromStringToDate(),
                inputReturnDate.text.toString().fromStringToDate(),
                inputNumberPassportPassenger.text.toString(),
                inputNamePassenger.text.toString(),
                FlightTicket.TypePassenger.ADULT
            )
        }
    }
}