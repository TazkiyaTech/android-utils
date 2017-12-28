package com.thinkincode.utils.collections;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ImmutableSet {

    /**
     * Creates an immutable copy of the provided {@link Collection}.
     *
     * @param collection the {@link Collection} to copy.
     * @param <T>        the type of the elements in the provided {@link Collection}.
     * @return an immutable copy of the provided {@link Collection}.
     */
    @NonNull
    public static <T> Set<T> copyOf(@NonNull Collection<T> collection) {
        return Collections.unmodifiableSet(new TreeSet<>(collection));
    }

    /**
     * Creates an immutable {@link Set} containing the given items.
     *
     * @param items the items to be contained in the {@link Set}.
     * @param <T> the type of the elements that the {@link Set} will be composed of.
     * @return an immutable {@link Set} containing the given items.
     */
    @SafeVarargs
    @NonNull
    public static <T> Set<T> of(@NonNull T... items) {
        return copyOf(Arrays.asList(items));
    }
}
