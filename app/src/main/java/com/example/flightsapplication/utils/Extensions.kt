package com.example.flightsapplication.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.openFragment(idFrameFragment: Int, fragment: Fragment, tag: String) {
    supportFragmentManager
        .beginTransaction()
        .replace(idFrameFragment, fragment, tag)
        .addToBackStack(tag)
        .commit()
}
