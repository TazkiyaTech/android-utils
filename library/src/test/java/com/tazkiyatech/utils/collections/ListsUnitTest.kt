package com.tazkiyatech.utils.collections

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListsUnitTest {

    @Test
    fun joinWithSpaceSeparator_without_to_index() {
        // When.
        val result = listOf("apple", "banana", "carrot").joinWithSpaceSeparator()

        // Then.
        assertEquals("apple banana carrot", result)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_0() {
        // When.
        val result = listOf("apple", "banana", "carrot").joinWithSpaceSeparator(0)

        // Then.
        assertEquals("", result)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_1() {
        // When.
        val result = listOf("apple", "banana", "carrot").joinWithSpaceSeparator(1)

        // Then.
        assertEquals("apple", result)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_2() {
        // When.
        val result = listOf("apple", "banana", "carrot").joinWithSpaceSeparator(2)

        // Then.
        assertEquals("apple banana", result)
    }

    @Test
    fun joinWithSpaceSeparator_with_to_index_of_3() {
        // When.
        val result = listOf("apple", "banana", "carrot").joinWithSpaceSeparator(3)

        // Then.
        assertEquals("apple banana carrot", result)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun joinWithSpaceSeparator_with_to_index_of_4() {
        // When.
        listOf("apple", "banana", "carrot").joinWithSpaceSeparator(4)
    }
}