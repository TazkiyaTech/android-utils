package com.tazkiyatech.utils.display

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.BulletSpan
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SpannableStringBuildersUnitTest {

    @Test
    fun appendBulletSpans() {
        // Given.
        val spannableStringBuilder = SpannableStringBuilder()

        // When.
        spannableStringBuilder.appendBulletSpans(
            arrayOf("apple", "banana"),
            true,
            5,
            3,
            Color.BLACK
        )

        // Then.
        val absoluteSizeSpans = spannableStringBuilder.getSpans(
            0,
            spannableStringBuilder.length,
            AbsoluteSizeSpan::class.java
        )

        assertEquals(2, absoluteSizeSpans.size)

        assertEquals(0, spannableStringBuilder.getSpanStart(absoluteSizeSpans[0]))
        assertEquals(2, spannableStringBuilder.getSpanEnd(absoluteSizeSpans[0]))

        assertEquals(7, spannableStringBuilder.getSpanStart(absoluteSizeSpans[1]))
        assertEquals(9, spannableStringBuilder.getSpanEnd(absoluteSizeSpans[1]))

        // And.
        val bulletSpans = spannableStringBuilder.getSpans(
            0,
            spannableStringBuilder.length,
            BulletSpan::class.java
        )

        assertEquals(2, bulletSpans.size)

        assertEquals(2, spannableStringBuilder.getSpanStart(bulletSpans[0]))
        assertEquals(7, spannableStringBuilder.getSpanEnd(bulletSpans[0]))

        assertEquals(9, spannableStringBuilder.getSpanStart(bulletSpans[1]))
        assertEquals(15, spannableStringBuilder.getSpanEnd(bulletSpans[1]))
    }

    @Test
    fun appendBulletSpan() {
        // Given.
        val spannableStringBuilder = SpannableStringBuilder()

        // When.
        spannableStringBuilder.appendBulletSpan(
            "apple",
            5,
            3,
            Color.BLACK
        )

        // Then.
        val absoluteSizeSpans = spannableStringBuilder.getSpans(
            0,
            spannableStringBuilder.length,
            AbsoluteSizeSpan::class.java
        )

        assertEquals(1, absoluteSizeSpans.size)

        val absoluteSizeSpan = absoluteSizeSpans[0]

        assertEquals(0, spannableStringBuilder.getSpanStart(absoluteSizeSpan))
        assertEquals(2, spannableStringBuilder.getSpanEnd(absoluteSizeSpan))

        assertEquals(5, absoluteSizeSpan.size)

        // And.
        val bulletSpans = spannableStringBuilder.getSpans(
            0,
            spannableStringBuilder.length,
            BulletSpan::class.java
        )

        assertEquals(1, bulletSpans.size)

        val bulletSpan = bulletSpans[0]

        assertEquals(2, spannableStringBuilder.getSpanStart(bulletSpan))
        assertEquals(7, spannableStringBuilder.getSpanEnd(bulletSpan))

        assertEquals(3, bulletSpan.gapWidth)
    }
}