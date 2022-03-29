package com.example.flightsapplication.presentation.fragment

import androidx.fragment.app.Fragment
import com.example.flightsapplication.R

class HistoryFragment: Fragment(R.layout.fragment_flight_history){
    companion object {
        const val TAG = "History fragment"
        fun newInstance() = HistoryFragment()
    }

}