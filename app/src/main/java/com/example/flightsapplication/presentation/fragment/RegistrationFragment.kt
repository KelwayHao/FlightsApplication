package com.example.flightsapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flightsapplication.R
import com.example.flightsapplication.databinding.FragmentFlightRegistrationBinding
import com.example.flightsapplication.domain.models.FlightTicket
import com.example.flightsapplication.presentation.datapickmanager.DataPickerManager
import com.example.flightsapplication.presentation.viewmodel.FlightFragmentViewModel
import com.example.flightsapplication.utils.openFragment
import com.example.flightsapplication.utils.showSnack
import com.google.android.material.switchmaterial.SwitchMaterial
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_flight_registration) {
    private val binding by viewBinding<FragmentFlightRegistrationBinding>()
    private val viewModel by viewModel<FlightFragmentViewModel>()
    private val dataPicker by lazy { DataPickerManager(requireContext()) }

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
        with(binding) {
            textViewOffSwitch.text = getString(R.string.adult)
            textViewOnSwitch.text = getString(R.string.child)
        }
    }

    private fun initViews() {
        with(binding) {
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
    }

    private fun createFlight() {
        with(binding){
            viewModel.createFlightTicket(
                inputFlightDeparture.text.toString(),
                inputFlightDestination.text.toString(),
                inputDepartDate.text.toString(),
                inputReturnDate.text.toString(),
                inputNumberPassportPassenger.text.toString(),
                inputNamePassenger.text.toString(),
                passengerAge.checkPassengerAge(),
            )
        }
        viewModel.snack.observe(viewLifecycleOwner) { event ->
            showSnack(getString(event), requireView())
        }
    }

    private fun checkHistory() {
        binding.buttonHistoryFlight.setOnClickListener {
            requireActivity().openFragment(
                R.id.frameFragment,
                HistoryFragment.newInstance(),
                HistoryFragment.TAG
            )
        }
    }

    private fun SwitchMaterial.checkPassengerAge(): FlightTicket.PassengerAge {
        return if (isChecked) FlightTicket.PassengerAge.CHILD else FlightTicket.PassengerAge.ADULT
    }
}