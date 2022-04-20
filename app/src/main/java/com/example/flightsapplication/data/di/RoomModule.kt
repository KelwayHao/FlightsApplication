package com.example.flightsapplication.data.di

import android.content.Context
import androidx.room.Room
import com.example.flightsapplication.data.storage.AppDatabase
import com.example.flightsapplication.data.storage.FlightTicketsDao
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "flighttickets"
        ).build()
    }

    @Provides
    fun provideFlightTicketDao(database: AppDatabase): FlightTicketsDao {
        return database.getFlightTickets()
    }
}
/*val roomModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "flighttickets"
        ).build()
    }

    single<FlightTicketsDao> {
        get<AppDatabase>().getFlightTickets()
    }
}*/