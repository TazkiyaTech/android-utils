package com.tazkiyatech.utils.streams;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Provides an easy method for copying the contents of an {@link InputStream} to an {@link OutputStream}.
 * <p>
 * The method contained in this class is taken from the Guava library's com.google.common.io.ByteStreams class.
 */
public class StreamCopier {

    private static final int BUFFER_SIZE_BYTES = 2048;

    /**
     * Copies all bytes from {@code inputStream} to {@code outputStream}.
     * Does not close either stream.
     *
     * @param inputStream  the {@link InputStream} to read from.
     * @param outputStream the {@link OutputStream} to write to.
     * @throws IOException if an I/O error occurs.
     */
    public void copy(@NonNull InputStream inputStream,
                     @NonNull OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE_BYTES];
        int length;

        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }

        outputStream.flush();
    }
}
