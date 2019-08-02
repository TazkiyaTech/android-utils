package com.tazkiyatech.utils.display

import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SpannableExtensionsUnitTest {

    @Test
    fun applyBoldStyleSpanToSubString() {
        // Given.
        val spannable = SpannableString("apple banana carrot")

        // When.
        spannable.applyBoldStyleSpanToSubString("banana")

        // Then.
        val spans = spannable.getSpans(0, spannable.length, StyleSpan::class.java)

        assertEquals(1, spans.size)
        assertEquals(6, spannable.getSpanStart(spans[0]))
        assertEquals(12, spannable.getSpanEnd(spans[0]))
    }

    @Test
    fun applyForegroundColorSpanToSubString() {
        // Given.
        val spannable = SpannableString("apple banana carrot")

        // When.
        spannable.applyForegroundColorSpanToSubString("banana", Color.BLACK)

        // Then.
        val spans = spannable.getSpans(0, spannable.length, ForegroundColorSpan::class.java)

        assertEquals(1, spans.size)
        assertEquals(6, spannable.getSpanStart(spans[0]))
        assertEquals(12, spannable.getSpanEnd(spans[0]))
    }

    @Test
    fun applyUnderlineSpanToSubString() {
        // Given.
        val spannable = SpannableString("apple banana carrot")

        // When.
        spannable.applyUnderlineSpanToSubString("banana")

        // Then.
        val spans = spannable.getSpans(0, spannable.length, UnderlineSpan::class.java)

        assertEquals(1, spans.size)
        assertEquals(6, spannable.getSpanStart(spans[0]))
        assertEquals(12, spannable.getSpanEnd(spans[0]))
    }
}