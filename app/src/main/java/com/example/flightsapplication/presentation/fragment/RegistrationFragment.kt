package com.example.flightsapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.viewmodel.FlightViewModel
import com.example.flightsapplication.utils.fromStringToDate
import com.example.flightsapplication.utils.showSnack
import kotlinx.android.synthetic.main.fragment_flight_registration.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RegistrationFragment : Fragment(R.layout.fragment_flight_registration) {

    private val viewModel: FlightViewModel by sharedViewModel()

    companion object {
        const val TAG = "Registration fragment"
        fun newInstance() = RegistrationFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        buttonConfirmFlight.setOnClickListener {
            if (inputFlightDeparture.text.isEmpty() ||
                inputFlightDestination.text.isEmpty() ||
                inputDepartDate.text.isEmpty() ||
                inputReturnDate.text.isEmpty() ||
                inputNumberPassportPassenger.text.isEmpty() ||
                inputNamePassenger.text.isEmpty()
            ) {
                showSnack(getString(R.string.show_snack_validation), this.requireView())
            } else {
                createFlight()
            }
        }
    }

    private fun createFlight() {
        viewModel.createFlightTicket(
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