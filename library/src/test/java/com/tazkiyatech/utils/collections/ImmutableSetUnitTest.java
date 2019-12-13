package com.tazkiyatech.utils.collections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImmutableSetUnitTest {

    @Test
    void of_with_single_item() {
        // When.
        Set<String> output = ImmutableSet.of("a");

        // Then.
        assertThat(output, contains("a"));
    }

    @Test
    void of_with_multiple_items() {
        // When.
        Set<String> output = ImmutableSet.of("a", "c", "b");

        // Then.
        assertThat(output, contains("a", "b", "c"));
    }

    @Test
    void modifying_input_after_creating_immutable_set_does_not_affect_immutable_list() {
        // Given.
        Set<String> input = new HashSet<>();
        input.add("a");

        Set<String> output = ImmutableSet.copyOf(input);

        // When.
        input.add("b");

        // Then.
        assertThat(output, contains("a"));
    }

    @Test
    void adding_item_to_immutable_set_throws_exception() {
        // Given.
        Set<String> input = new HashSet<>();
        input.add("a");

        Set<String> output = ImmutableSet.copyOf(input);

        // When.
        assertThrows(UnsupportedOperationException.class, () -> output.add("b"));
    }

    @Test
    void removing_item_from_immutable_set_throws_exception() {
        // Given.
        Set<String> input = new HashSet<>();
        input.add("a");

        Set<String> output = ImmutableSet.copyOf(input);

        // When.
        assertThrows(UnsupportedOperationException.class, output::clear);
    }
}