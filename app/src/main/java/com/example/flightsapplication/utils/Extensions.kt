package com.example.flightsapplication.utils

import android.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.flightsapplication.R
import com.google.android.material.snackbar.Snackbar

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

fun Fragment.dialog(message: String, context: Context, onPositiveButtonClick: () -> Unit, onNegativeButtonClick: () -> Unit) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(R.string.warning)
        .setMessage(message)
        .setCancelable(true)
        .setPositiveButton(getString(R.string.sure)) { dialogMessage, _ ->
            onPositiveButtonClick()
            dialogMessage.cancel()
        }
        .setNegativeButton(getString(R.string.cancel)) { dialogMessage, _ ->
            onNegativeButtonClick()
            dialogMessage.cancel()
        }
    builder.show()
}

fun String.checkValidPassport(): Boolean {
    return Regex(Constant.VALID_PASSPORT_FORMAT).matches(this)
}