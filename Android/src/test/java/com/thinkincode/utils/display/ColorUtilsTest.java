package com.thinkincode.utils.display;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

/**
 * Tests for the methods in the {@link ColorUtils} class.
 */
@RunWith(JUnit4.class)
public class ColorUtilsTest {

    private ColorUtils colorUtils;

    @Before
    public void setUp() {
        colorUtils = new ColorUtils();
    }

    @Test
    public void test_rgbColorToHexString_black() {
        // When.
        String actual = colorUtils.rgbColorToHexString(Color.BLACK);

        // Then.
        assertEquals("#000000", actual);
    }

    @Test
    public void test_rgbColorToHexString_white() {
        // When.
        String actual = colorUtils.rgbColorToHexString(Color.WHITE);

        // Then.
        assertEquals("#FFFFFF", actual);
    }

    @Test
    public void test_rgbColorToHexString_blue() {
        // When.
        String actual = colorUtils.rgbColorToHexString(Color.BLUE);

        // Then.
        assertEquals("#0000FF", actual);
    }

    @Test
    public void test_rgbColorToHexString_green() {
        // When.
        String actual = colorUtils.rgbColorToHexString(Color.GREEN);

        // Then.
        assertEquals("#00FF00", actual);
    }

    @Test
    public void test_rgbColorToHexString_red() {
        // When.
        String actual = colorUtils.rgbColorToHexString(Color.RED);

        // Then.
        assertEquals("#FF0000", actual);
    }
}
