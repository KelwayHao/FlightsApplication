package com.example.flightsapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.datapickmanager.DataPickerManager
import com.example.flightsapplication.presentation.listeners.ValidationListener
import com.example.flightsapplication.presentation.viewmodel.FlightFragmentViewModel
import com.example.flightsapplication.utils.checkPassengerAge
import com.example.flightsapplication.utils.openFragment
import com.example.flightsapplication.utils.showSnack
import kotlinx.android.synthetic.main.fragment_flight_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_flight_registration) {

    private val viewModel: FlightFragmentViewModel by viewModel<FlightFragmentViewModel>()


    companion object {
        const val TAG = "Registration fragment"
        fun newInstance() = RegistrationFragment()
    }

    private val isValidListener = object: ValidationListener {
        override fun validationListener(message: Int) {
            showSnack(getString(message),requireView())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        checkHistory()
        initTextSwitchComponent()
        viewModel.getFlightTickets()
    }

    private fun initTextSwitchComponent() {
        textViewOffSwitch.text = FlightTicket.PassengerAge.ADULT.type
        textViewOnSwitch.text = FlightTicket.PassengerAge.CHILD.type
    }

    private fun initViews() {

        val dataPicker = DataPickerManager(requireContext())

        inputDepartDate.setOnClickListener {
            dataPicker.openDataTimePicker(inputDepartDate)
        }

        inputReturnDate.setOnClickListener {
            dataPicker.openDataTimePicker(inputReturnDate)
        }

        buttonConfirmFlight.setOnClickListener {
            createFlight()
        }
    }

    private fun createFlight() {
        val idTicket: Long = viewModel.getSize()
        val d = idTicket
        viewModel.createFlightTicket(
            idTicket,
            inputFlightDeparture.text.toString(),
            inputFlightDestination.text.toString(),
            inputDepartDate.text.toString(),
            inputReturnDate.text.toString(),
            inputNumberPassportPassenger.text.toString(),
            inputNamePassenger.text.toString(),
            passengerAge.checkPassengerAge(),
            isValidListener
        )
    }

    private fun checkHistory() {
        buttonHistoryFlight.setOnClickListener {
            requireActivity().openFragment(
                R.id.frameFragment,
                HistoryFragment.newInstance(),
                HistoryFragment.TAG
            )
        }
    }
}