package com.thinkincode.utils.lang;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.NoSuchElementException;

/**
 * A container object which may or may not contain a non-null value.
 * <p>
 * This class is an alternative for the <a href="https://developer.android.com/reference/java/util/Optional.html">java.util.Optional</a> class
 * to be used in projects that have a minimum Android SDK version lower than API level 24.
 * (The <a href="https://developer.android.com/reference/java/util/Optional.html">java.util.Optional</a> class was added to Android in API level 24
 * and thus is not available in earlier versions).
 *
 * @param <T> the type of value that is held.
 * @see <a href="https://developer.android.com/reference/java/util/Optional.html">https://developer.android.com/reference/java/util/Optional.html</a>
 */
public class Optional<T> {

    @Nullable
    private final T value;

    /**
     * Returns an {@link Optional} instance which contains a null value.
     */
    @NonNull
    public static <T> Optional<T> empty() {
        return new Optional<>(null);
    }

    /**
     * Returns an {@link Optional} instance which contains the provided value.
     */
    @NonNull
    public static <T> Optional<T> of(@NonNull T value) {
        return new Optional<>(value);
    }

    /**
     * Constructor.
     */
    private Optional(@Nullable T value) {
        this.value = value;
    }

    /**
     * Returns true if the value held by this {@link Optional} is non-null, otherwise false.
     */
    public boolean isPresent() {
        return value != null;
    }

    /**
     * If a value is present in this {@link Optional}, returns the value,
     * otherwise throws {@link NoSuchElementException}.
     *
     * @return the value held by this {@link Optional}.
     * @throws NoSuchElementException if the value held by this {@link Optional} is null.
     */
    @NonNull
    public T get() throws NoSuchElementException {
        if (value == null) {
            throw new NoSuchElementException("There is no value to get from this Optional");
        }

        return value;
    }
}
