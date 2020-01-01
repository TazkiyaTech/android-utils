package com.tazkiyatech.utils.display

import android.graphics.Typeface
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import androidx.annotation.ColorInt

/**
 * Applies the bold [StyleSpan] to the first occurrence of the given substring in this [Spannable].
 */
fun Spannable.applyBoldStyleSpanToSubString(subString: String) {

    val subStringStartIndex = indexOf(subString)
    val subStringEndIndex = subStringStartIndex + subString.length

    setSpan(
        StyleSpan(Typeface.BOLD),
        subStringStartIndex,
        subStringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}

/**
 * Applies the [ForegroundColorSpan] to the first occurrence of the given substring in this [Spannable].
 */
fun Spannable.applyForegroundColorSpanToSubString(
    subString: String,
    @ColorInt color: Int
) {

    val subStringStartIndex = indexOf(subString)
    val subStringEndIndex = subStringStartIndex + subString.length

    setSpan(
        ForegroundColorSpan(color),
        subStringStartIndex,
        subStringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}

/**
 * Applies the italic [StyleSpan] to the first occurrence of the given substring in this [Spannable].
 */
fun Spannable.applyItalicStyleSpanToSubString(subString: String) {

    val subStringStartIndex = indexOf(subString)
    val subStringEndIndex = subStringStartIndex + subString.length

    setSpan(
        StyleSpan(Typeface.ITALIC),
        subStringStartIndex,
        subStringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}

/**
 * Applies the [UnderlineSpan] to the first occurrence of the given substring in this [Spannable].
 */
fun Spannable.applyUnderlineSpanToSubString(subString: String) {

    val subStringStartIndex = indexOf(subString)
    val subStringEndIndex = subStringStartIndex + subString.length

    setSpan(
        UnderlineSpan(),
        subStringStartIndex,
        subStringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}