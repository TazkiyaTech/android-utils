package com.tazkiyatech.utils.lang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class OptionalTest {

    @Test
    public void test_isPresent_optional_has_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable(null);

        // When. / Then.
        assertFalse(optional.isPresent());
    }

    @Test
    public void test_isPresent_optional_has_non_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable("Some value");

        // When. / Then.
        assertTrue(optional.isPresent());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_get_when_optional_has_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable(null);

        // When. / Then.
        optional.get();
    }

    @Test
    public void test_get_when_optional_has_non_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable("Some value");

        // When. / Then.
        assertEquals("Some value", optional.get());
    }

    @Test
    public void test_orElse_when_optional_has_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable(null);

        // When. / Then.
        assertEquals("Some alternative value", optional.orElse("Some alternative value"));
    }

    @Test
    public void test_orElse_when_optional_has_non_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable("Some value");

        // When. / Then.
        assertEquals("Some value", optional.orElse("Some value"));
    }

    @Test(expected = RuntimeException.class)
    public void test_orElseThrow_when_optional_has_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable(null);

        // When. / Then.
        optional.orElseThrow(new RuntimeException("Some exception"));
    }

    @Test
    public void test_orElseThrow_when_optional_has_non_null_value() {
        // Given.
        Optional<String> optional = Optional.ofNullable("Some value");

        // When. / Then.
        assertEquals("Some value", optional.orElseThrow(new RuntimeException("Some exception")));
    }
}