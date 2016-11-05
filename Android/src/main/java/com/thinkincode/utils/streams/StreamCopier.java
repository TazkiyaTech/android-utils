package com.thinkincode.utils.streams;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopier {

    private static final int BUFFER_SIZE_BYTES = 2048;

    /**
     * Copies all bytes from {@code inputStream} to {@code outputStream}.
     * Does not close or flush either stream.
     *
     * @param inputStream the {@link InputStream} to read from.
     * @param outputStream the {@link OutputStream} to write to.
     * @throws IOException if an I/O error occurs.
     */
    public void copy(@NonNull InputStream inputStream,
                     @NonNull OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE_BYTES];

        while (true) {
            int r = inputStream.read(buffer);

            if (r == -1) {
                break;
            }

            outputStream.write(buffer, 0, r);
        }
    }
}
