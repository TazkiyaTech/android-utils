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
    public void test_readAll() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));

        StringInputStream stringInputStream = new StringInputStream(inputStream);

        // When.
        String output = stringInputStream.readAll();
        stringInputStream.close();

        // Then.
        assertEquals(input, output);
    }

    @Test
    public void test_calling_readAll_after_readAll_has_already_been_called() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));

        StringInputStream stringInputStream = new StringInputStream(inputStream);
        stringInputStream.readAll();

        // When.
        String output = stringInputStream.readAll();
        stringInputStream.close();

        // Then.
        assertEquals("", output);
    }

    @Test
    public void test_calling_readAll_after_close_has_been_called() throws IOException {
        // Given.
        String input = "Hello\nHello\tHello";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));

        StringInputStream stringInputStream = new StringInputStream(inputStream);
        stringInputStream.close();

        // When.
        String output = stringInputStream.readAll();
        stringInputStream.close();

        // Then.
        assertEquals(input, output);
    }
}
