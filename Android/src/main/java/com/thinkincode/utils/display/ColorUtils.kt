package com.thinkincode.utils.display

/**
 * Converts the color to its #RRGGBB Hexadecimal String representation.
 *
 * The alpha component of the color is ignored.
 *
 * @return the #RRGGBB Hexadecimal String representation of the color.
 */
fun Int.toRGBHexadecimalString(): String {
    return String.format("#%06X", 0xFFFFFF and this)
}

/**
 * Converts the color to its #AARRGGBB Hexadecimal String representation.
 *
 * @return the #AARRGGBB Hexadecimal String representation of the color.
 */
fun Int.toARGBHexadecimalString(): String {
    return String.format("#%08X", this)
}
