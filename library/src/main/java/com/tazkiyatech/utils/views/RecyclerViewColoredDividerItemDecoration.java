package com.tazkiyatech.utils.views;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * An extension of {@link RecyclerView.ItemDecoration} that
 * draws a colored divider between each item in a {@link RecyclerView}.
 * <p>
 * Unlike the {@link androidx.recyclerview.widget.DividerItemDecoration} class offered by the
 * <a href="https://maven.google.com/web/index.html#androidx.recyclerview:recyclerview">recyclerview</a>
 * library, this class does not draw a divider under the final item in the {@link RecyclerView}.
 * <p>
 * See <a href="https://stackoverflow.com/a/27037230/1071320">this answer</a> in Stack Overflow
 * for a better understanding of {@link RecyclerView.ItemDecoration}.
 */
public class RecyclerViewColoredDividerItemDecoration extends RecyclerView.ItemDecoration {

    private final Drawable dividerDrawable;
    private final int dividerHeightPixels;
    private final int dividerMarginLeftPixels;
    private final int dividerMarginRightPixels;

    /**
     * Constructor.
     *
     * @param dividerColor             The color to apply to the divider.
     * @param dividerHeightPixels      The height to apply to the divider (in pixels).
     * @param dividerMarginLeftPixels  The left margin to apply to the divider (in pixels).
     * @param dividerMarginRightPixels The right margin to apply to the divider (in pixels).
     */
    public RecyclerViewColoredDividerItemDecoration(@ColorInt int dividerColor,
                                                    int dividerHeightPixels,
                                                    int dividerMarginLeftPixels,
                                                    int dividerMarginRightPixels) {
        this.dividerDrawable = new ColorDrawable(dividerColor);
        this.dividerHeightPixels = dividerHeightPixels;
        this.dividerMarginLeftPixels = dividerMarginLeftPixels;
        this.dividerMarginRightPixels = dividerMarginRightPixels;
    }

    @Override
    public void onDrawOver(@NonNull Canvas c,
                           @NonNull RecyclerView parent,
                           @NonNull RecyclerView.State state) {
        int left = dividerMarginLeftPixels;
        int right = parent.getWidth() - dividerMarginRightPixels;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams childLayoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + childLayoutParams.bottomMargin;
            int bottom = top + dividerHeightPixels;

            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(c);
        }
    }
}
