package com.thinkincode.utils.display;

import android.content.res.Resources;
import android.support.annotation.NonNull;

/**
 * Class containing helper methods for converting between different dimension units.
 */
public class DimensionUtils {

    @NonNull
    private final Resources resources;

    /**
     * Constructor.
     */
    public DimensionUtils(@NonNull Resources resources) {
        this.resources = resources;
    }

    /**
     * Converts the given number of pixels
     * to the corresponding number of density independent pixels using the formula:
     * dip = px / (dpi / 160).
     */
    public float convertPxToDip(float pixels) {
        float scalingFactor = getScreenDensity();
        return pixels / scalingFactor;
    }

    /**
     * Converts the given number of density independent pixels
     * to the corresponding number of pixels using the formula:
     * px = dip * (dpi / 160).
     */
    public float convertDipToPx(float dip) {
        float scalingFactor = getScreenDensity();
        return dip * scalingFactor;
    }

    /**
     * @return the logical density of the display.
     */
    private float getScreenDensity() {
        return resources.getDisplayMetrics().density;
    }
}
