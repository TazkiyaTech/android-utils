package com.thinkincode.utils.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ImmutableMapsTest {

    @Test
    public void test_create_withMapContainingSingleItem() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("SomeKey", "SomeValue");

        // When.
        Map<String, String> output = ImmutableMaps.copyOf(input);

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void test_create_withMapContainingMultipleItems() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");
        input.put("Key2", "Value2");
        input.put("Key3", "Value3");

        // When.
        Map<String, String> output = ImmutableMaps.copyOf(input);

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void test_modifyingInputAfterCreatingImmutableMapDoesNotAffectImmutableMap() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMaps.copyOf(input);

        // When.
        input.put("Key2", "Value2");

        // Then.
        assertEquals(Collections.singletonMap("Key1", "Value1"), output);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_addingItemToImmutableMapThrowsException() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMaps.copyOf(input);

        // When.
        output.put("Key2", "Value2");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_removingItemFromImmutableMapThrowsException() {
        // Given.
        Map<String, String> input = new HashMap<>();
        input.put("Key1", "Value1");

        Map<String, String> output = ImmutableMaps.copyOf(input);

        // When.
        output.clear();
    }
}
