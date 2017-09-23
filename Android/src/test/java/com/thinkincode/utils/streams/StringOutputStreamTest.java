package com.thinkincode.utils.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class StringOutputStreamTest {

    @Test
    public void test_write() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        StringOutputStream stringOutputStream = new StringOutputStream(outputStream);

        // When.
        stringOutputStream.write(input);
        stringOutputStream.close();

        // Then.
        String output = new String(outputStream.toByteArray(), "UTF-8");

        assertEquals(input, output);
    }

    @Test
    public void test_write_after_write_has_already_been_called() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        StringOutputStream stringOutputStream = new StringOutputStream(outputStream);
        stringOutputStream.write(input);

        // When.
        stringOutputStream.write(input);
        stringOutputStream.close();

        // Then.
        String output = new String(outputStream.toByteArray(), "UTF-8");

        assertEquals(input + input, output);
    }

    @Test
    public void test_write_after_close_has_been_called() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        StringOutputStream stringOutputStream = new StringOutputStream(outputStream);
        stringOutputStream.close();

        // When.
        stringOutputStream.write(input);
        stringOutputStream.close();

        // Then.
        String output = new String(outputStream.toByteArray(), "UTF-8");

        assertEquals(input, output);
    }
}
