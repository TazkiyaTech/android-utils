package com.thinkincode.utils.streams;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Provides an easy method for writing a {@link String} to an {@link OutputStream}.
 */
public class StringOutputStream {

    /**
     * Writes {@code value} to {@code outputStream}
     * and then closes {@code outputStream}.
     *
     * @param value        the {@link String} value to write.
     * @param outputStream the {@link OutputStream} to write to.
     * @throws IOException if an I/O error occurs.
     */
    public void write(@NonNull String value,
                      @NonNull OutputStream outputStream) throws IOException {
        try {
            outputStream.write(value.getBytes(Charset.forName("UTF-8")));
        } finally {
            close(outputStream);
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
