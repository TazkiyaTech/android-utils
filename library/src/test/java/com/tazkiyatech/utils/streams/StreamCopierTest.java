package com.tazkiyatech.utils.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class StreamCopierTest {

    @Test
    public void test_copy() throws IOException {
        // Given.
        StreamCopier streamCopier = new StreamCopier();

        String input = "Hello\nHello\tHello";
        String output;

        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // When.
            streamCopier.copy(inputStream, outputStream);
            output = new String(outputStream.toByteArray(), "UTF-8");
        }

        // Then.
        assertEquals(input, output);
    }
}
