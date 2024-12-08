package com.myapp.colorpicker

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue


fun Float.toDp(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics
    )
}

fun Int.toDp(context: Context): Int {
    val density = context.resources.displayMetrics.density
    return (this * density).toInt()
}

fun Int.isDarkColor(): Boolean {
    val darkness =
        1 - (0.299 * Color.red(this) + 0.587 * Color.green(this) + 0.114 * Color.blue(this)) / 255
    return if (darkness < 0.5) {
        false
    } else {
        true
    }
}

fun Int.isShowRate(): Boolean {
    return this in listOf(2, 4, 6, 10, 14)
}
