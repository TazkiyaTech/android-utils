package com.tazkiyatech.utils.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CollectionExtensionsUnitTest {

    @ParameterizedTest(name = "collection={0}, input={1}, expected={2}")
    @MethodSource("provideArguments")
    fun containsAny_when_elements_is_collection(collection: Collection<String>,
                                                input: Collection<String>,
                                                expected: Boolean) {
        // When.
        val actual = collection.containsAny(input)

        // Then.
        assertEquals(expected, actual)
    }

    @ParameterizedTest(name = "collection={0}, input={1}, expected={2}")
    @MethodSource("provideArguments")
    fun containsAny_when_elements_is_vararg(collection: Collection<String>,
                                            input: Collection<String>,
                                            expected: Boolean) {
        // When.
        val actual = collection.containsAny(*input.toTypedArray())

        // Then.
        assertEquals(expected, actual)
    }

    companion object {

        @JvmStatic
        @Suppress("unused")
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(
                    arguments(emptyList<String>(), emptyList<String>(), false),
                    arguments(emptyList<String>(), listOf("a", "b", "c"), false),
                    arguments(listOf("a", "b", "c"), emptyList<String>(), false),
                    arguments(listOf("a", "b", "c"), listOf("d"), false),
                    arguments(listOf("a", "b", "c"), listOf("c"), true),
            )
        }
    }
}
