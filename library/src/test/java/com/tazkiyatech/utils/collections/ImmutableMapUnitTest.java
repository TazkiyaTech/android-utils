package com.tazkiyatech.utils.collections;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImmutableMapUnitTest {

    @Test
    void copyOf_with_map_containing_single_item() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("SomeKey", "SomeValue");

        // When.
        Map<String, String> output = ImmutableMap.copyOf(input);

        // Then.
        assertEquals(input, output);
    }

    @Test
    void copyOf_with_map_containing_multiple_items() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");
        input.put("Key3", "Value3");
        input.put("Key2", "Value2");

        // When.
        Map<String, String> output = ImmutableMap.copyOf(input);

        // Then.
        assertEquals(input, output);
    }

    @Test
    void copyOf_returns_map_ordered_by_its_keys() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");
        input.put("Key3", "Value3");
        input.put("Key2", "Value2");

        // When.
        Map<String, String> output = ImmutableMap.copyOf(input);

        // Then.
        assertThat(output.values(), contains("Value1", "Value2", "Value3"));
    }

    @Test
    void modifying_input_after_creating_immutable_map_does_not_affect_immutable_map() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMap.copyOf(input);

        // When.
        input.put("Key2", "Value2");

        // Then.
        assertEquals(Collections.singletonMap("Key1", "Value1"), output);
    }

    @Test
    void adding_item_to_immutable_map_throws_exception() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMap.copyOf(input);

        // When.
        assertThrows(UnsupportedOperationException.class, () -> output.put("Key2", "Value2"));
    }

    @Test
    void removing_item_from_immutable_map_throws_exception() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMap.copyOf(input);

        // When.
        assertThrows(UnsupportedOperationException.class, output::clear);
    }
}
