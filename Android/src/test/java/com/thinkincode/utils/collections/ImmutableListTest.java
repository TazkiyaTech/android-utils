package com.thinkincode.utils.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(JUnit4.class)
public class ImmutableListTest {

    @Test
    public void test_copyOf_withListContainingSingleItem() {
        // Given.
        List<String> input = Collections.singletonList("a");

        // When.
        List<String> output = ImmutableList.copyOf(input);

        // Then.
        assertThat(output, contains("a"));
    }

    @Test
    public void test_copyOf_withListContainingMultipleItems() {
        // Given.
        List<String> input = Arrays.asList("a", "b", "c");

        // When.
        List<String> output = ImmutableList.copyOf(input);

        // Then.
        assertThat(output, contains("a", "b", "c"));
    }

    @Test
    public void test_modifyingInputAfterCreatingImmutableListDoesNotAffectImmutableList() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableList.copyOf(input);

        // When.
        input.add("b");

        // Then.
        assertThat(output, contains("a"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_addingItemToImmutableListThrowsException() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableList.copyOf(input);

        // When.
        output.add("b");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_removingItemFromImmutableListThrowsException() {
        // Given.
        List<String> input = new ArrayList<>();
        input.add("a");

        List<String> output = ImmutableList.copyOf(input);

        // When.
        output.clear();
    }
}
