package com.thinkincode.utils.display

import android.content.res.Resources

/**
 * Converts the given number of pixels
 * to the corresponding number of density independent pixels using the formula:
 * dip = px / (dpi / 160).
 */
fun Resources.convertPxToDip(pixels: Float): Float {
    val scalingFactor = screenDensity
    return pixels / scalingFactor
}

/**
 * Converts the given number of density independent pixels
 * to the corresponding number of pixels using the formula:
 * px = dip * (dpi / 160).
 */
fun Resources.convertDipToPx(dip: Float): Float {
    val scalingFactor = screenDensity
    return dip * scalingFactor
}

/**
 * The logical density of the display.
 *
 * @see android.util.DisplayMetrics.density
 */
val Resources.screenDensity: Float
    get() = displayMetrics.density