package com.tazkiyatech.utils.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ListExtensionsUnitTest {

    @Test
    fun joinWithSpaceSeparator_without_to_index() {
        // Given.
        val input = listOf("apple", "banana", "carrot")

        // When.
        val output = input.joinWithSpaceSeparator()

        // Then.
        assertEquals("apple banana carrot", output)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_0() {
        // Given.
        val input = listOf("apple", "banana", "carrot")

        // When.
        val output = input.joinWithSpaceSeparator(0)

        // Then.
        assertEquals("", output)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_1() {
        // Given.
        val input = listOf("apple", "banana", "carrot")

        // When.
        val output = input.joinWithSpaceSeparator(1)

        // Then.
        assertEquals("apple", output)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_2() {
        // Given.
        val input = listOf("apple", "banana", "carrot")

        // When.
        val output = input.joinWithSpaceSeparator(2)

        // Then.
        assertEquals("apple banana", output)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_3() {
        // Given.
        val input = listOf("apple", "banana", "carrot")

        // When.
        val output = input.joinWithSpaceSeparator(3)

        // Then.
        assertEquals("apple banana carrot", output)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_4() {
        // Given.
        val input = listOf("apple", "banana", "carrot")

        // When.
        assertThrows(IndexOutOfBoundsException::class.java) { input.joinWithSpaceSeparator(4) }
    }
}