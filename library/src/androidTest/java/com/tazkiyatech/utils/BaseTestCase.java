package com.tazkiyatech.utils;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

public abstract class BaseTestCase {

    /**
     * Performs some pre-test setup.
     */
    protected void setUp() {
        // nothing to do
    }

    /**
     * Performs some post-test teardown.
     */
    protected void tearDown() {
        // nothing to do
    }

    /**
     * @return the {@link Context} for the target application being instrumented.
     */
    protected Context getContext() {
        return ApplicationProvider.getApplicationContext();
    }
}
