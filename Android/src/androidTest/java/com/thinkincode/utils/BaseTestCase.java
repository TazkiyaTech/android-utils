package com.thinkincode.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

public abstract class BaseTestCase {

    /**
     * Performs some pre-test setup.
     */
    protected void setUp() {
        // nothing to do
    }

    /**
     * @return the {@link Context} for the target application being instrumented.
     */
    protected Context getContext() {
        return InstrumentationRegistry.getTargetContext();
    }
}
