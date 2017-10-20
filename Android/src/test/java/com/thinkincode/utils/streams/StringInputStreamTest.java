package com.thinkincode.utils.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class StringInputStreamTest {

    @Test
    public void test_read() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
             StringInputStream stringInputStream = new StringInputStream(inputStream)) {
            // When.
            output = stringInputStream.read();
        }

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void test_read_after_read_has_already_been_called() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
             StringInputStream stringInputStream = new StringInputStream(inputStream)) {
            stringInputStream.read();

            // When.
            output = stringInputStream.read();
        }

        // Then.
        assertEquals("", output);
    }

    @Test
    public void test_read_after_close_has_been_called() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
             StringInputStream stringInputStream = new StringInputStream(inputStream)) {
            stringInputStream.close();

            // When.
            output = stringInputStream.read();
        }

        // Then.
        assertEquals(input, output);
    }
}
