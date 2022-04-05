package com.example.flightsapplication.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flighttickets")
data class FlightTicketEntity(
    @PrimaryKey
    var id: Long,
    @ColumnInfo(name = "departure")
    val departure: String,
    @ColumnInfo(name = "destination")
    val destination: String,
    @ColumnInfo(name = "depart_date")
    val departDate: String,
    @ColumnInfo(name = "return_date")
    val returnDate: String,
    @ColumnInfo(name = "number_passport_passenger")
    val numberPassportPassenger: String,
    @ColumnInfo(name = "name_passenger")
    val namePassenger: String,
    @ColumnInfo(name = "passenger_age")
    val passengerAge: Int
)
