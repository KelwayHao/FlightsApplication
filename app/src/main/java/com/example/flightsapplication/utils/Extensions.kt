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

fun showSnack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}

fun SwitchMaterial.checkPassengerAge(): FlightTicket.PassengerAge {
    return if (isChecked) FlightTicket.PassengerAge.CHILD else FlightTicket.PassengerAge.ADULT
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

