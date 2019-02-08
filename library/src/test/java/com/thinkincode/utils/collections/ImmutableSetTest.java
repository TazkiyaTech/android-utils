package com.thinkincode.utils.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(JUnit4.class)
public class ImmutableSetTest {

    @Test
    public void test_of_withSingleItem() {
        // When.
        Set<String> output = ImmutableSet.of("a");

        // Then.
        assertThat(output, contains("a"));
    }

    @Test
    public void test_of_withMultipleItems() {
        // When.
        Set<String> output = ImmutableSet.of("a", "c", "b");

        // Then.
        assertThat(output, contains("a", "b", "c"));
    }

    @Test
    public void test_modifyingInputAfterCreatingImmutableSetDoesNotAffectImmutableList() {
        // Given.
        Set<String> input = new HashSet<>();
        input.add("a");

        Set<String> output = ImmutableSet.copyOf(input);

        // When.
        input.add("b");

        // Then.
        assertThat(output, contains("a"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_addingItemToImmutableListThrowsException() {
        // Given.
        Set<String> input = new HashSet<>();
        input.add("a");

        Set<String> output = ImmutableSet.copyOf(input);

        // When.
        output.add("b");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_removingItemFromImmutableListThrowsException() {
        // Given.
        Set<String> input = new HashSet<>();
        input.add("a");

        Set<String> output = ImmutableSet.copyOf(input);

        // When.
        output.clear();
    }
}