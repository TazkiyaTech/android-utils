package com.tazkiyatech.utils.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class StringOutputStreamUnitTest {

    @Test
    public void write() throws Exception {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             StringOutputStream stringOutputStream = new StringOutputStream(outputStream)) {
            // When.
            stringOutputStream.write(input);

            output = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
        }

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void write_after_write_has_already_been_called() throws Exception {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             StringOutputStream stringOutputStream = new StringOutputStream(outputStream)) {
            stringOutputStream.write(input);

            // When.
            stringOutputStream.write(input);

            // Then.
            output = new String(outputStream.toByteArray(), UTF_8);
        }

        assertEquals(input + input, output);
    }

    @Test
    public void write_after_close_has_been_called() throws Exception {
        // Given.
        String input = "Hello\nHello\tHello";
        String output;

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             StringOutputStream stringOutputStream = new StringOutputStream(outputStream)) {
            stringOutputStream.close();

            // When.
            stringOutputStream.write(input);

            output = new String(outputStream.toByteArray(), UTF_8);
        }

        // Then.
        assertEquals(input, output);
    }
}
