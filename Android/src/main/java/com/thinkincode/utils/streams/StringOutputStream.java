package com.thinkincode.utils.streams;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Provides an easy method for writing a {@link String} to an {@link OutputStream}.
 */
public class StringOutputStream {

    @NonNull
    private final OutputStream outputStream;

    /**
     * Constructor.
     *
     * @param outputStream the {@link OutputStream} instance to write to.
     */
    public StringOutputStream(@NonNull OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Writes {@code value} to the {@link OutputStream} instance that this class wraps.
     *
     * @param value        the {@link String} value to write to the output stream.
     * @throws IOException if an I/O error occurs.
     */
    public void write(@NonNull String value) throws IOException {
        outputStream.write(value.getBytes(Charset.forName("UTF-8")));
    }

    /**
     * Flushes and closes the {@link OutputStream} instance that this class wraps.
     */
    public void close() {
        try {
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            // nothing to do
        }
    }
}
