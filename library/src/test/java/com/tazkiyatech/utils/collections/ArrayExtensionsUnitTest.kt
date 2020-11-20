package com.tazkiyatech.utils.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ArrayExtensionsUnitTest {

    @ParameterizedTest(name = "collection={0}, input={1}, expected={2}")
    @MethodSource("provideArguments")
    fun containsAny(collection: Array<Any>,
                    input: Array<Any>,
                    expected: Boolean) {
        // When.
        val actual = collection.containsAny(*input)

        // Then.
        assertEquals(expected, actual)
    }

    companion object {

        @JvmStatic
        @Suppress("unused")
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(
                    arguments(emptyArray<Any>(), emptyArray<Any>(), false),
                    arguments(emptyArray<Any>(), arrayOf("a", "b", "c"), false),
                    arguments(arrayOf("a", "b", "c"), emptyArray<Any>(), false),
                    arguments(arrayOf("a", "b", "c"), arrayOf("d"), false),
                    arguments(arrayOf("a", "b", "c"), arrayOf("a"), true),
                    arguments(arrayOf("a", "b", "c"), arrayOf("b", "c"), true),
            )
        }
    }
}
