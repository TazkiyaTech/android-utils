package com.thinkincode.utils.display

import android.graphics.Typeface
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan

fun Spannable.applyBoldStyleSpanToSubString(
    subString: String
) {
    val subStringStartIndex = indexOf(subString)
    val subStringEndIndex = subStringStartIndex + subString.length

    setSpan(
        StyleSpan(Typeface.BOLD),
        subStringStartIndex,
        subStringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}

fun Spannable.applyForegroundColorSpanToSubString(
    subString: String,
    color: Int
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