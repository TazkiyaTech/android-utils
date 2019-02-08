package com.tazkiyatech.utils.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;

public class ImmutableList {

    /**
     * Creates an immutable copy of the provided {@link Collection}.
     *
     * @param collection the {@link Collection} to copy.
     * @param <T>        the type of the elements in the provided {@link Collection}.
     * @return an immutable copy of the provided {@link Collection}.
     */
    @NonNull
    public static <T> List<T> copyOf(@NonNull Collection<T> collection) {
        return Collections.unmodifiableList(new ArrayList<>(collection));
    }
}
