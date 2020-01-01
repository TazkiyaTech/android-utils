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
fun Spannable.applyBoldStyleSpanToSubstring(substring: String) {

    val substringStartIndex = indexOf(substring)
    val substringEndIndex = substringStartIndex + substring.length

    setSpan(
        StyleSpan(Typeface.BOLD),
        substringStartIndex,
        substringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}

/**
 * Applies the [ForegroundColorSpan] to the first occurrence of the given substring in this [Spannable].
 */
fun Spannable.applyForegroundColorSpanToSubstring(substring: String, @ColorInt color: Int) {

    val substringStartIndex = indexOf(substring)
    val substringEndIndex = substringStartIndex + substring.length

    setSpan(
        ForegroundColorSpan(color),
        substringStartIndex,
        substringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}

/**
 * Applies the italic [StyleSpan] to the first occurrence of the given substring in this [Spannable].
 */
fun Spannable.applyItalicStyleSpanToSubstring(substring: String) {

    val substringStartIndex = indexOf(substring)
    val substringEndIndex = substringStartIndex + substring.length

    setSpan(
        StyleSpan(Typeface.ITALIC),
        substringStartIndex,
        substringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}

/**
 * Applies the [UnderlineSpan] to the first occurrence of the given substring in this [Spannable].
 */
fun Spannable.applyUnderlineSpanToSubstring(substring: String) {

    val substringStartIndex = indexOf(substring)
    val substringEndIndex = substringStartIndex + substring.length

    setSpan(
        UnderlineSpan(),
        substringStartIndex,
        substringEndIndex,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}