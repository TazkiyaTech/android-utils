package com.tazkiyatech.utils.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImmutableListUnitTest {

    @Test
    void copyOf_with_list_containing_single_item() {
        // Given.
        List<String> input = Collections.singletonList("a");

        // When.
        List<String> output = ImmutableList.copyOf(input);

        // Then.
        assertThat(output, contains("a"));
    }

    @Test
    void copyOf_with_list_containing_multiple_items() {
        // Given.
        List<String> input = Arrays.asList("a", "b", "c");

        // When.
        List<String> output = ImmutableList.copyOf(input);

        // Then.
        assertThat(output, contains("a", "b", "c"));
    }

    @Test
    void modifying_input_after_creating_immutable_set_does_not_affect_immutable_list() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableList.copyOf(input);

        // When.
        input.add("b");

        // Then.
        assertThat(output, contains("a"));
    }

    @Test
    void adding_item_to_immutable_list_throws_exception() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableList.copyOf(input);

        // When.
        assertThrows(UnsupportedOperationException.class, () -> output.add("b"));
    }

    @Test
    void removing_item_from_immutable_list_throws_exception() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableList.copyOf(input);

        // When.
        assertThrows(UnsupportedOperationException.class, output::clear);
    }
}
