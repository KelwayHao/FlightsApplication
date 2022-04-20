package com.example.flightsapplication.utils.resourceprovider

import android.content.Context

class ResourcesProviderImpl(private val context: Context): ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }

}