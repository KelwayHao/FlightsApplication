package com.example.flightsapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flightsapplication.R
import com.example.flightsapplication.databinding.ActivityMainBinding
import com.example.flightsapplication.presentation.fragment.RegistrationFragment
import com.example.flightsapplication.utils.openFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
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