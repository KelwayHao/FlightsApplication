package com.example.flightsapplication.utils.resourceprovider

import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes id: Int): String
}
