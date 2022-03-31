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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        checkHistory()
        initTextSwitchComponent()
    }

    private fun initTextSwitchComponent() {
        textViewOffSwitch.text = FlightTicket.TypePassenger.ADULT.type
        textViewOnSwitch.text = FlightTicket.TypePassenger.CHILD.type
    }

    private fun initViews() {

        inputDepartDate.setOnClickListener {
            openDataAndTimePicker(inputDepartDate)
        }

        inputReturnDate.setOnClickListener {
            openDataAndTimePicker(inputReturnDate)
        }

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
                showSnack(getString(R.string.message_flight_success), this.requireView())
            }
        }
    }

    private fun createFlight() {
        viewModel.createFlightTicket(
            idF,
            inputFlightDeparture.text.toString(),
            inputFlightDestination.text.toString(),
            inputDepartDate.text.toString().fromStringToDate(),
            inputReturnDate.text.toString().fromStringToDate(),
            inputNumberPassportPassenger.text.toString(),
            inputNamePassenger.text.toString(),
            typePassenger.checkTypePassenger()
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