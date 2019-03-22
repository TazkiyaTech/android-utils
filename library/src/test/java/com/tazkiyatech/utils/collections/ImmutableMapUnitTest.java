package com.tazkiyatech.utils.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ImmutableMapUnitTest {

    @Test
    public void copyOf_withMapContainingSingleItem() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("SomeKey", "SomeValue");

        // When.
        Map<String, String> output = ImmutableMap.copyOf(input);

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void copyOf_withMapContainingMultipleItems() {
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
    public void copyOf_returnsMapOrderedByItsKeys() {
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
    public void modifyingInputAfterCreatingImmutableMapDoesNotAffectImmutableMap() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMap.copyOf(input);

        // When.
        input.put("Key2", "Value2");

        // Then.
        assertEquals(Collections.singletonMap("Key1", "Value1"), output);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addingItemToImmutableMapThrowsException() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMap.copyOf(input);

        // When.
        output.put("Key2", "Value2");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removingItemFromImmutableMapThrowsException() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMap.copyOf(input);

        // When.
        output.clear();
    }
}
