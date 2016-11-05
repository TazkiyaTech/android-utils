package com.thinkincode.utils.streams;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class StringInputStreamTest {

    @Test
    public void test_read() throws IOException {
        // Given.
        StringInputStream stringInputStream = new StringInputStream();

        String input = "Hello\nHello\tHello";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));

        // When.
        String output = stringInputStream.read(inputStream);

        // Then.
        assertEquals(input, output);
    }
}
