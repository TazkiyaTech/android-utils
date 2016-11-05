package com.thinkincode.utils.streams;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class StreamCopierTest {

    @Test
    public void test_copy() throws IOException {
        // Given.
        StreamCopier streamCopier = new StreamCopier();

        String input = "Hello\nHello\tHello";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // When.
        streamCopier.copy(inputStream, outputStream);

        String output = new String(outputStream.toByteArray(), "UTF-8");

        // Then.
        assertEquals(input, output);
    }
}
