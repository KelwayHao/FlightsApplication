package com.example.flightsapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flightsapplication.R
import com.example.flightsapplication.databinding.ActivityMainBinding
import com.example.flightsapplication.presentation.fragment.RegistrationFragment
import com.example.flightsapplication.utils.openFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initView()
    }

    private fun initView() {
        openFragment(
            R.id.frameFragment,
            RegistrationFragment.newInstance(),
            RegistrationFragment.TAG
        )
    }
}