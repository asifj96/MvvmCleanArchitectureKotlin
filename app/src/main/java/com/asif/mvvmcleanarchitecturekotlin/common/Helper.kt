package com.asif.mvvmcleanarchitecturekotlin.common

import android.content.Context
import android.os.SystemClock
import android.widget.Toast

fun Context.showToast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
}
private var mLastClickTime: Long = 0

fun disableClick(): Boolean {

    if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
        return false
    }
    mLastClickTime = SystemClock.elapsedRealtime()
    return true
}