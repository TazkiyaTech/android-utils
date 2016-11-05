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

    private static final int BUFFER_SIZE_BYTES = 2048;

    @NonNull
    private final InputStream inputStream;

    /**
     * Constructor.
     *
     * @param inputStream the {@link InputStream} instance to read in from.
     */
    public StringInputStream(@NonNull InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Reads in the contents of the {@link InputStream} instance that this class wraps.
     *
     * @return the value read in from the input stream.
     * @throws IOException if an I/O error occurs.
     */
    @NonNull
    public String read() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(BUFFER_SIZE_BYTES);

        try {
            byte[] buffer = new byte[BUFFER_SIZE_BYTES];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        } finally {
            close(outputStream);
        }

        return outputStream.toString("UTF-8");
    }

    /**
     * Closes the {@link InputStream} instance that this class wraps.
     */
    public void close() {
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
