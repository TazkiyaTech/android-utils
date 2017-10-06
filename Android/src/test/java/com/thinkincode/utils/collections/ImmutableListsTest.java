package com.thinkincode.utils.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ImmutableListsTest {

    @Test
    public void test_create_withListContainingSingleItem() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        // When.
        List<String> output = ImmutableLists.copyOf(input);

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void test_create_withListContainingMultipleItems() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        input.add("c");

        // When.
        List<String> output = ImmutableLists.copyOf(input);

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void test_modifyingInputAfterCreatingImmutableListDoesNotAffectImmutableList() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableLists.copyOf(input);

        // When.
        input.add("b");

        // Then.
        assertEquals(Collections.singletonList("a"), output);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_addingItemToImmutableListThrowsException() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableLists.copyOf(input);

        // When.
        output.add("b");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_removingItemFromImmutableListThrowsException() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableLists.copyOf(input);

        // When.
        output.clear();
    }
}
