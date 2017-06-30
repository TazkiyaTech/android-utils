package com.thinkincode.utils.lang;

/**
 * An empty class which differs from the {@link java.lang.Void} class in that this class can be instantiated.
 */
public class Void {

    /**
     * @return an instance of {@link com.thinkincode.utils.lang.Void}.
     */
    public static Void instance() {
        return new Void();
    }

    /**
     * Constructor to be called by the {@link #instance()} method.
     */
    private Void() {
        // nothing to do
    }
}
