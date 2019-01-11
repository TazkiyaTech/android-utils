package com.thinkincode.utils.collections;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ImmutableMap {

    /**
     * Creates an immutable copy of the provided {@link Map}.
     *
     * @param map the {@link Map} to copy.
     * @param <K> the type of the keys in the provided {@link Map}.
     * @param <V> the type of the values in the provided {@link Map}.
     * @return an immutable copy of the provided {@link Map}.
     */
    @NonNull
    public static <K, V> Map<K, V> copyOf(@NonNull Map<K, V> map) {
        return Collections.unmodifiableMap(new TreeMap<>(map));
    }
}
