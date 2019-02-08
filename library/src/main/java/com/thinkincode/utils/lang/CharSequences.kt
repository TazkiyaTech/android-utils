package com.thinkincode.utils.lang

/**
 * Surrounds the [CharSequence] with a pair of round brackets ().
 *
 * @return the [CharSequence] surrounded with a pair of round brackets ().
 */
fun CharSequence.parenthesise(): String {
    return "($this)"
}

/**
 * Splits this [CharSequence] around spaces.
 *
 * @return a [List] of the words in this [CharSequence]
 * where a "word" is what comes between one sequence of spaces and the next.
 */
fun CharSequence.splitOnSpaces(): List<String> {
    return split(" ".toRegex()).filter { it.isNotEmpty() }
}

/**
 * @return a count of the number of characters in this [CharSequence]
 * but such that Arabic vowel marks on letters are excluded from the count.
 */
fun CharSequence.numberOfCharactersExcludingArabicVowelMarks(): Int {
    var count = 0

    var previousCharacterWasSpace = true

    for (i in indices) {
        val c = get(i)

        if ((c >= 0x610.toChar() && c <= 0x061A.toChar())
            || (c >= 0x064B.toChar() && c <= 0x065F.toChar())
            || (c == 0x0670.toChar())
            || (c == 0x0674.toChar())
            || (c >= 0x06D6.toChar() && c <= 0x06DC.toChar())
            || (c >= 0x06DF.toChar() && c <= 0x06E8.toChar())
            || (c >= 0x06EA.toChar() && c <= 0x06ED.toChar())
            || (c >= 0x08E3.toChar() && c <= 0x08FF.toChar())
        ) { // c is a vowel mark
            if (previousCharacterWasSpace) {
                count++
            }
            previousCharacterWasSpace = false
        } else if (c == 0x0020.toChar()) {
            count++
            previousCharacterWasSpace = true
        } else {
            count++
            previousCharacterWasSpace = false
        }
    }

    return count
}