package com.example.flightsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.flightsapplication.presentation.fragment.HistoryFragment
import com.example.flightsapplication.presentation.fragment.RegistrationFragment
import com.example.flightsapplication.utils.openFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        initView()
        checkHistory()
    }



    private fun initView() {
        openFragment(R.id.frameFragment, RegistrationFragment.newInstance(), RegistrationFragment.TAG)
    }

    private fun checkHistory() {
        buttonHistoryFlight.setOnClickListener{
            openFragment(R.id.frameFragment, HistoryFragment.newInstance(), HistoryFragment.TAG)
        }
    }
}