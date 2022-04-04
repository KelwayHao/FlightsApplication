package com.example.flightsapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.flightsapplication.R
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.viewmodel.RegistrationFlightFragmentViewModel
import com.example.flightsapplication.utils.*
import kotlinx.android.synthetic.main.fragment_flight_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_flight_registration) {

    private val viewModel: RegistrationFlightFragmentViewModel by viewModel<RegistrationFlightFragmentViewModel>()
    private var idF: Long = 0

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
        viewModel.createFlightTicket(
            idF,
            inputFlightDeparture.text.toString(),
            inputFlightDestination.text.toString(),
            inputDepartDate.text.toString(),
            inputReturnDate.text.toString(),
            inputNumberPassportPassenger.text.toString(),
            inputNamePassenger.text.toString(),
            passengerAge.checkPassengerAge(),
            isValidListener
        )
        idF++
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