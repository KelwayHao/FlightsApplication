package com.example.flightsapplication

import android.content.Context
import com.example.flightsapplication.data.di.DataModule
import com.example.flightsapplication.data.di.RoomModule
import com.example.flightsapplication.domain.di.ViewModelModule
import com.example.flightsapplication.domain.di.DomainModelModule
import com.example.flightsapplication.presentation.fragment.HistoryFragment
import com.example.flightsapplication.presentation.fragment.RegistrationFragment
import com.example.flightsapplication.utils.di.UtilsModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModule::class, RoomModule::class, DomainModelModule::class, UtilsModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun inject(target: HistoryFragment)
    fun inject(target: RegistrationFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context) : Builder
        fun build() : AppComponent
    }
}