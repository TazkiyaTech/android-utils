package com.thinkincode.utils.display;

/**
 * Provides helper methods for converting between different colour representations.
 */
public class ColorUtils {

    /**
     * Converts the provided color to its #RRGGBB Hex String representation.
     * <p>
     * The alpha component of the color is ignored.
     *
     * @param color the color to convert.
     * @return the #RRGGBB Hex String representation of the provided color.
     */
    public static String convertColorToRGBHexString(int color) {
        return String.format("#%06X", (0xFFFFFF & color));
    }

    /**
     * Converts the provided color to its #AARRGGBB Hex String representation.
     *
     * @param color the color to convert.
     * @return the #AARRGGBB Hex String representation of the provided color.
     */
    public static String convertColorToARGBHexString(int color) {
        return String.format("#%08X", color);
    }
}
