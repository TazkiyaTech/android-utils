package com.thinkincode.utils.lang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(JUnit4.class)
public class OptionalTest {

    @Test
    public void test_isPresent_optional_has_null_value() {
        // Given.
        Optional<String> optional = Optional.empty();

        // When. / Then.
        assertFalse(optional.isPresent());
    }

    @Test
    public void test_isPresent_optional_has_non_null_value() {
        // Given.
        Optional<String> optional = Optional.of("Some Value");

        // When. / Then.
        assertTrue(optional.isPresent());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_get_when_optional_has_null_value() {
        // Given.
        Optional<String> optional = Optional.empty();

        // When. / Then.
        assertEquals("Some Value", optional.get());
    }

    @Test
    public void test_get_when_optional_has_non_null_value() {
        // Given.
        Optional<String> optional = Optional.of("Some Value");

        // When. / Then.
        assertEquals("Some Value", optional.get());
    }
}