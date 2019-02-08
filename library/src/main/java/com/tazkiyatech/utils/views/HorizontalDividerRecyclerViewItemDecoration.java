package com.tazkiyatech.utils.views;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * An extension of {@link RecyclerView.ItemDecoration} that
 * – when applied to a {@link RecyclerView} –
 * draws a horizontal divider at the bottom of each item in the {@link RecyclerView}.
 * <p>
 * This class is a modification of N J's answer on Stack Overflow here:
 * <a href="http://stackoverflow.com/a/31243174/1071320">http://stackoverflow.com/a/31243174/1071320</a>
 */
public class HorizontalDividerRecyclerViewItemDecoration extends RecyclerView.ItemDecoration {

    private final Drawable dividerDrawable;
    private final int dividerHeightPixels;
    private final int dividerMarginLeftPixels;
    private final int dividerMarginRightPixels;

    /**
     * Constructor.
     *
     * @param dividerColor             the color value to apply to the divider.
     * @param dividerHeightPixels      the height to apply to the divider (in pixels).
     * @param dividerMarginLeftPixels  the size of the left margin (in pixels).
     * @param dividerMarginRightPixels the size of the right margin (in pixels).
     */
    public HorizontalDividerRecyclerViewItemDecoration(int dividerColor,
                                                       int dividerHeightPixels,
                                                       int dividerMarginLeftPixels,
                                                       int dividerMarginRightPixels) {
        this.dividerDrawable = new ColorDrawable(dividerColor);
        this.dividerHeightPixels = dividerHeightPixels;
        this.dividerMarginLeftPixels = dividerMarginLeftPixels;
        this.dividerMarginRightPixels = dividerMarginRightPixels;
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
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
