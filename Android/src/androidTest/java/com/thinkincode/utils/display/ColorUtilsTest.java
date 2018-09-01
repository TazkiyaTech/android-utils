package com.thinkincode.utils.display;

import android.graphics.Color;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Tests for the methods in the {@link ColorUtils} class.
 */
@RunWith(AndroidJUnit4.class)
public class ColorUtilsTest {

    @Test
    public void test_convertColorToRGBHexString_00000000() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#00000000"));

        // Then.
        assertEquals("#000000", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_00000000() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#00000000"));

        // Then.
        assertEquals("#00000000", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_FF000000() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#FF000000"));

        // Then.
        assertEquals("#000000", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_FF000000() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#FF000000"));

        // Then.
        assertEquals("#FF000000", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_000000() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#000000"));

        // Then.
        assertEquals("#000000", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_000000() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#000000"));

        // Then.
        assertEquals("#FF000000", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_FFFFFFFF() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#FFFFFFFF"));

        // Then.
        assertEquals("#FFFFFF", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_FFFFFFFF() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#FFFFFFFF"));

        // Then.
        assertEquals("#FFFFFFFF", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_FFFFFF() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#FFFFFF"));

        // Then.
        assertEquals("#FFFFFF", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_FFFFFF() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#FFFFFF"));

        // Then.
        assertEquals("#FFFFFFFF", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_FF0000FF() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#FF0000FF"));

        // Then.
        assertEquals("#0000FF", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_FF0000FF() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#FF0000FF"));

        // Then.
        assertEquals("#FF0000FF", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_0000FF() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#0000FF"));

        // Then.
        assertEquals("#0000FF", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_0000FF() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#0000FF"));

        // Then.
        assertEquals("#FF0000FF", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_FF00FF00() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#FF00FF00"));

        // Then.
        assertEquals("#00FF00", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_FF00FF00() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#FF00FF00"));

        // Then.
        assertEquals("#FF00FF00", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_00FF00() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#00FF00"));

        // Then.
        assertEquals("#00FF00", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_00FF00() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#00FF00"));

        // Then.
        assertEquals("#FF00FF00", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_FFFF0000() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#FFFF0000"));

        // Then.
        assertEquals("#FF0000", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_FFFF0000() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#FFFF0000"));

        // Then.
        assertEquals("#FFFF0000", actual);
    }

    @Test
    public void test_convertColorToRGBHexString_FF0000() {
        // When.
        String actual = ColorUtils.convertColorToRGBHexString(Color.parseColor("#FF0000"));

        // Then.
        assertEquals("#FF0000", actual);
    }

    @Test
    public void test_convertColorToARGBHexString_FF0000() {
        // When.
        String actual = ColorUtils.convertColorToARGBHexString(Color.parseColor("#FF0000"));

        // Then.
        assertEquals("#FFFF0000", actual);
    }
}
