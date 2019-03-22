package com.tazkiyatech.utils.display

import android.graphics.Color
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColorsUnitTest {

    @Test
    fun toRGBHexadecimal_with_00000000() {
        // When.
        val actual = Color.parseColor("#00000000").toRGBHexadecimalString()

        // Then.
        assertEquals("#000000", actual)
    }

    @Test
    fun toARGBHexadecimal_with_00000000() {
        // When.
        val actual = Color.parseColor("#00000000").toARGBHexadecimalString()

        // Then.
        assertEquals("#00000000", actual)
    }

    @Test
    fun toRGBHexadecimal_with_FF000000() {
        // When.
        val actual = Color.parseColor("#FF000000").toRGBHexadecimalString()

        // Then.
        assertEquals("#000000", actual)
    }

    @Test
    fun toARGBHexadecimal_with_FF000000() {
        // When.
        val actual = Color.parseColor("#FF000000").toARGBHexadecimalString()

        // Then.
        assertEquals("#FF000000", actual)
    }

    @Test
    fun toRGBHexadecimal_with_000000() {
        // When.
        val actual = Color.parseColor("#000000").toRGBHexadecimalString()

        // Then.
        assertEquals("#000000", actual)
    }

    @Test
    fun toARGBHexadecimal_with_000000() {
        // When.
        val actual = Color.parseColor("#000000").toARGBHexadecimalString()

        // Then.
        assertEquals("#FF000000", actual)
    }

    @Test
    fun toRGBHexadecimal_with_FFFFFFFF() {
        // When.
        val actual = Color.parseColor("#FFFFFFFF").toRGBHexadecimalString()

        // Then.
        assertEquals("#FFFFFF", actual)
    }

    @Test
    fun toARGBHexadecimal_with_FFFFFFFF() {
        // When.
        val actual = Color.parseColor("#FFFFFFFF").toARGBHexadecimalString()

        // Then.
        assertEquals("#FFFFFFFF", actual)
    }

    @Test
    fun toRGBHexadecimal_with_FFFFFF() {
        // When.
        val actual = Color.parseColor("#FFFFFF").toRGBHexadecimalString()

        // Then.
        assertEquals("#FFFFFF", actual)
    }

    @Test
    fun toARGBHexadecimal_with_FFFFFF() {
        // When.
        val actual = Color.parseColor("#FFFFFF").toARGBHexadecimalString()

        // Then.
        assertEquals("#FFFFFFFF", actual)
    }

    @Test
    fun toRGBHexadecimal_with_FF0000FF() {
        // When.
        val actual = Color.parseColor("#FF0000FF").toRGBHexadecimalString()

        // Then.
        assertEquals("#0000FF", actual)
    }

    @Test
    fun toARGBHexadecimal_with_FF0000FF() {
        // When.
        val actual = Color.parseColor("#FF0000FF").toARGBHexadecimalString()

        // Then.
        assertEquals("#FF0000FF", actual)
    }

    @Test
    fun toRGBHexadecimal_with_0000FF() {
        // When.
        val actual = Color.parseColor("#0000FF").toRGBHexadecimalString()

        // Then.
        assertEquals("#0000FF", actual)
    }

    @Test
    fun toARGBHexadecimal_with_0000FF() {
        // When.
        val actual = Color.parseColor("#0000FF").toARGBHexadecimalString()

        // Then.
        assertEquals("#FF0000FF", actual)
    }

    @Test
    fun toRGBHexadecimal_with_FF00FF00() {
        // When.
        val actual = Color.parseColor("#FF00FF00").toRGBHexadecimalString()

        // Then.
        assertEquals("#00FF00", actual)
    }

    @Test
    fun toARGBHexadecimal_with_FF00FF00() {
        // When.
        val actual = Color.parseColor("#FF00FF00").toARGBHexadecimalString()

        // Then.
        assertEquals("#FF00FF00", actual)
    }

    @Test
    fun toRGBHexadecimal_with_00FF00() {
        // When.
        val actual = Color.parseColor("#00FF00").toRGBHexadecimalString()

        // Then.
        assertEquals("#00FF00", actual)
    }

    @Test
    fun toARGBHexadecimal_with_00FF00() {
        // When.
        val actual = Color.parseColor("#00FF00").toARGBHexadecimalString()

        // Then.
        assertEquals("#FF00FF00", actual)
    }

    @Test
    fun toRGBHexadecimal_with_FFFF0000() {
        // When.
        val actual = Color.parseColor("#FFFF0000").toRGBHexadecimalString()

        // Then.
        assertEquals("#FF0000", actual)
    }

    @Test
    fun toARGBHexadecimal_with_FFFF0000() {
        // When.
        val actual = Color.parseColor("#FFFF0000").toARGBHexadecimalString()

        // Then.
        assertEquals("#FFFF0000", actual)
    }

    @Test
    fun toRGBHexadecimal_with_FF0000() {
        // When.
        val actual = Color.parseColor("#FF0000").toRGBHexadecimalString()

        // Then.
        assertEquals("#FF0000", actual)
    }

    @Test
    fun toARGBHexadecimal_with_FF0000() {
        // When.
        val actual = Color.parseColor("#FF0000").toARGBHexadecimalString()

        // Then.
        assertEquals("#FFFF0000", actual)
    }
}
