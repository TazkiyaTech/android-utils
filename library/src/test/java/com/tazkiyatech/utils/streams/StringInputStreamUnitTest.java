package com.tazkiyatech.utils.streams;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringInputStreamUnitTest {

    @Test
    void read() throws Exception {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
             StringInputStream stringInputStream = new StringInputStream(inputStream)) {
            // When.
            output = stringInputStream.read();
        }

        // Then.
        assertEquals(input, output);
    }

    @Test
    void read_after_read_has_already_been_called() throws Exception {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
             StringInputStream stringInputStream = new StringInputStream(inputStream)) {
            stringInputStream.read();

            // When.
            output = stringInputStream.read();
        }

        // Then.
        assertEquals("", output);
    }

    @Test
    void read_after_close_has_been_called() throws Exception {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
             StringInputStream stringInputStream = new StringInputStream(inputStream)) {
            stringInputStream.close();

            // When.
            output = stringInputStream.read();
        }

        // Then.
        assertEquals(input, output);
    }
}
