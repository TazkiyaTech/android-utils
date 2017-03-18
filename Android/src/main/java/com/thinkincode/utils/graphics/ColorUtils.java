package com.thinkincode.utils.graphics;

public class ColorUtils {

    /**
     * Converts an RGB int color to its Hex String representation.
     *
     * @param rgbColor the RGB int color to convert.
     * @return the Hex String representation of the provided RGB int color.
     */
    public static String rgbColorToHexString(int rgbColor) {
        return String.format("#%06X", (0xFFFFFF & rgbColor));
    }
}
