package com.tazkiyatech.utils.streams;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamCopierUnitTest {

    @Test
    void copy() throws Exception {
        // Given.
        StreamCopier streamCopier = new StreamCopier();

        String input = "Hello\nHello\tHello";
        String output;

        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // When.
            streamCopier.copy(inputStream, outputStream);
            output = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
        }

        // Then.
        assertEquals(input, output);
    }
}
