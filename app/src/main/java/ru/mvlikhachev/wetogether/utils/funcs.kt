package ru.mvlikhachev.wetogether.utils

import android.widget.Toast

class funcs {

    fun showToast(message: String) {
        Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
    }
}