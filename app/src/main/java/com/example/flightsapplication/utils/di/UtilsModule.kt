package com.example.flightsapplication.utils.di

import android.content.Context
import com.example.flightsapplication.utils.resourceprovider.ResourceProvider
import com.example.flightsapplication.utils.resourceprovider.ResourcesProviderImpl
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourcesProviderImpl(context)
    }
}