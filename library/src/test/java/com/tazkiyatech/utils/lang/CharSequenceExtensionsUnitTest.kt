package com.tazkiyatech.utils.lang

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CharSequenceExtensionsUnitTest {

    @Test
    fun parenthesise_with_empty_string() {
        // When.
        val result = "".parenthesise()

        // Then.
        assertEquals("()", result)
    }

    @Test
    fun parenthesise_with_non_empty_string() {
        // When.
        val result = "foo".parenthesise()

        // Then.
        assertEquals("(foo)", result)
    }

    @Test
    fun splitOnSpaces_with_empty_string() {
        // When.
        val result = "".splitOnSpaces()

        // Then.
        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun splitOnSpaces_with_single_space() {
        // When.
        val result = " ".splitOnSpaces()

        // Then.
        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun splitOnSpaces_with_double_space() {
        // When.
        val result = "  ".splitOnSpaces()

        // Then.
        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun splitOnSpaces_with_three_words_and_single_spaces() {
        // When.
        val result = "apple banana carrot".splitOnSpaces()

        // Then.
        assertEquals(listOf("apple", "banana", "carrot"), result)
    }

    @Test
    fun splitOnSpaces_with_three_words_and_double_spaces() {
        // When.
        val result = "apple  banana  carrot".splitOnSpaces()

        // Then.
        assertEquals(listOf("apple", "banana", "carrot"), result)
    }

    @Test
    fun numberOfCharactersExcludingArabicVowelMarks_with_surah_1_ayah_1() {
        // When.
        val result =
                "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ".numberOfCharactersExcludingArabicVowelMarks()

        // Then.
        assertEquals(22, result)
    }

    @Test
    fun numberOfCharactersExcludingArabicVowelMarks_with_surah_2_ayah_1() {
        // When.
        val result = "الم".numberOfCharactersExcludingArabicVowelMarks()

        // Then.
        assertEquals(3, result)
    }

    @Test
    fun numberOfCharactersExcludingArabicVowelMarks_with_surah_2_ayah_2() {
        // When.
        val result =
                "ذَٰلِكَ الْكِتَابُ لَا رَيْبَ ۛ فِيهِ ۛ هُدًى لِلْمُتَّقِينَ".numberOfCharactersExcludingArabicVowelMarks()

        // Then.
        assertEquals(37, result)
    }

    @Test
    fun numberOfCharactersExcludingArabicVowelMarks_with_surah_2_ayah_4() {
        // When.
        val result =
                "وَالَّذِينَ يُؤْمِنُونَ بِمَا أُنْزِلَ إِلَيْكَ وَمَا أُنْزِلَ مِنْ قَبْلِكَ وَبِالْآخِرَةِ هُمْ يُوقِنُونَ".numberOfCharactersExcludingArabicVowelMarks()

        // Then.
        assertEquals(63, result)
    }

    @Test
    fun numberOfCharactersExcludingArabicVowelMarks_with_surah_2_ayah_5() {
        // When.
        val result =
                "أُولَٰئِكَ عَلَىٰ هُدًى مِنْ رَبِّهِمْ ۖ وَأُولَٰئِكَ هُمُ الْمُفْلِحُونَ".numberOfCharactersExcludingArabicVowelMarks()

        // Then.
        assertEquals(42, result)
    }

    @Test
    fun numberOfCharactersExcludingArabicVowelMarks_with_surah_4_ayah_148() {
        // When.
        val result =
                "لَا يُحِبُّ اللَّهُ الْجَهْرَ بِالسُّوءِ مِنَ الْقَوْلِ إِلَّا مَنْ ظُلِمَ ۚ وَكَانَ اللَّهُ سَمِيعًا عَلِيمًا".numberOfCharactersExcludingArabicVowelMarks()

        // Then.
        assertEquals(68, result)
    }
}