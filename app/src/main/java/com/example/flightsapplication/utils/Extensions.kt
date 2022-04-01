package com.example.flightsapplication.utils

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.flightsapplication.R
import com.example.flightsapplication.data.storage.entity.FlightTicketEntity
import com.example.flightsapplication.domain.models.FlightTicket
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import java.text.SimpleDateFormat
import java.util.*

fun FragmentActivity.openFragment(idFrameFragment: Int, fragment: Fragment, tag: String) {
    supportFragmentManager
        .beginTransaction()
        .replace(idFrameFragment, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun FlightTicketEntity.toFlightTicket() =
    FlightTicket(
        departure = departure,
        destination = destination,
        departDate = departDate.fromStringToDate(),
        returnDate = returnDate.fromStringToDate(),
        numberPassportPassenger = numberPassportPassenger,
        namePassenger = namePassenger,
        typePassenger = typePassenger.toTypePassenger(),
        id = id
    )


fun FlightTicket.toFlightTicketEntity() =
    FlightTicketEntity(
        departure = departure,
        destination = destination,
        departDate = departDate.fromDateToString(),
        returnDate = returnDate.fromDateToString(),
        numberPassportPassenger = numberPassportPassenger,
        namePassenger = namePassenger,
        typePassenger = typePassenger.type,
        id = id
    )


@SuppressLint("SimpleDateFormat")
fun String.fromStringToDate(): Date {
    return SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).parse(this)
        ?: throw IllegalStateException("Wrong format input")
}

@SuppressLint("SimpleDateFormat")
fun Date.fromDateToString(): String {
    return SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(this)
}

fun String.toTypePassenger(): FlightTicket.TypePassenger {
    return FlightTicket.TypePassenger.valueOf(this.uppercase())
}

fun showSnack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}

fun SwitchMaterial.checkTypePassenger(): FlightTicket.TypePassenger {
    return if (isChecked) FlightTicket.TypePassenger.CHILD else FlightTicket.TypePassenger.ADULT
}

val calendar: Calendar = Calendar.getInstance()

@SuppressLint("SetTextI18n")
fun Fragment.openDataAndTimePicker(textView: TextView) {

    val datePickerDialog = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.YEAR, year)
        textView.text = "${calendar.get(Calendar.DAY_OF_MONTH)}-${calendar.get(Calendar.MONTH)}-${
            calendar.get(Calendar.YEAR)
        }"
        timePickTime(textView)
    }

    DatePickerDialog(
        requireContext(),
        datePickerDialog,
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show()
}

@SuppressLint("SetTextI18n")
fun Fragment.timePickTime(textView: TextView) {
    val timePickerDialog = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        textView.text =
            "${textView.text} ${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
    }

    TimePickerDialog(
        requireContext(),
        timePickerDialog,
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        false
    ).show()
}

fun Fragment.dialog(message: String, context: Context, deleteFlight: () -> Unit) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(R.string.warning)
        .setMessage(message)
        .setCancelable(true)
        .setPositiveButton("Yes") { dialogMessage, _ ->
            deleteFlight()
            dialogMessage.cancel()
        }
        .setNegativeButton("No") { dialogMessage, _ ->
            dialogMessage.cancel()
        }
    builder.show()
}

