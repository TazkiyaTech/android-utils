package com.thinkincode.utils.streams;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class StringOutputStreamTest {

    @Test
    public void test_write() throws IOException {
        // Given.
        StringOutputStream stringOutputStream = new StringOutputStream();

        String input = "Hello\nHello\tHello";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // When.
        stringOutputStream.write(input, outputStream);

        String output = new String(outputStream.toByteArray(), "UTF-8");

        // Then.
        assertEquals(input, output);
    }
}
