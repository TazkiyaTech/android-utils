package com.thinkincode.utils.streams;

import android.support.annotation.NonNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Provides an easy method for reading in the contents of an {@link InputStream}
 * and converting it to a {@link String}.
 */
public class StringInputStream {

    private static final int BUFFER_SIZE_BYTES = 1024;

    /**
     * Reads in the contents of {@code inputStream} and then closes {@code inputStream}.
     *
     * @param inputStream the {@link InputStream} instance to read in from.
     * @return the value read in from {@code inputStream}.
     * @throws IOException
     */
    public String read(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(BUFFER_SIZE_BYTES);

        try {
            byte[] buffer = new byte[BUFFER_SIZE_BYTES];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        } finally {
            close(outputStream);
            close(inputStream);
        }

        return outputStream.toString("UTF-8");
    }

    /**
     * Closes {@code inputStream}.
     *
     * @param inputStream the {@link InputStream} to close.
     */
    private void close(@NonNull InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException ex) {
            // nothing to do
        }
    }

    /**
     * Flushes and closes {@code outputStream}.
     *
     * @param outputStream the {@link OutputStream} to flush and close.
     */
    private void close(@NonNull OutputStream outputStream) {
        try {
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            // nothing to do
        }
    }
}
