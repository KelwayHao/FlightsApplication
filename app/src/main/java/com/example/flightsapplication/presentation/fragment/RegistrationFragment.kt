package com.example.flightsapplication.presentation.fragment

import androidx.fragment.app.Fragment
import com.example.flightsapplication.R

class RegistrationFragment : Fragment(R.layout.fragment_flight_registration) {
    companion object {
        const val TAG = "Registration fragment"
        fun newInstance() = RegistrationFragment()
    }
}