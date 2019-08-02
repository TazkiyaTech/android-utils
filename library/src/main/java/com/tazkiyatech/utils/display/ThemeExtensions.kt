package com.tazkiyatech.utils.display

import android.content.res.Resources
import android.util.TypedValue

/**
 * Gets the color which corresponds to the [android.R.attr.textColorPrimary] attribute in this theme,
 * or otherwise returns [defaultColor] if the attribute is not defined.
 */
fun Resources.Theme.getTextColorPrimaryOrElse(defaultColor: Int): Int {
    val typedValue = TypedValue()

    resolveAttribute(android.R.attr.textColorPrimary, typedValue, true)

    val typedArray = obtainStyledAttributes(
        typedValue.data,
        intArrayOf(android.R.attr.textColorPrimary)
    )

    val color = typedArray.getColor(0, defaultColor)

    typedArray.recycle()

    return color
}