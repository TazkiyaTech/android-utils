package com.thinkincode.utils.collections;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableLists {

    /**
     * Creates an immutable copy of the provided {@link List}.
     *
     * @param list the {@link List} to copy.
     * @param <T>  the type of the elements in the provided {@link List}.
     * @return an immutable copy of the provided {@link List}.
     */
    @NonNull
    public static <T> List<T> copyOf(@NonNull List<T> list) {
        return Collections.unmodifiableList(new ArrayList<>(list));
    }
}
