package com.thinkincode.utils.views;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <p>An extension of {@link android.support.v7.widget.RecyclerView.ItemDecoration} that
 * – when applied to a {@link RecyclerView} –
 * draws a horizontal divider at the bottom of each item in the {@link RecyclerView}.</p>
 *
 * <p>This class is a modification of N J's answer on Stack Overflow here:
 * <a href="http://stackoverflow.com/a/31243174/1071320">http://stackoverflow.com/a/31243174/1071320</a></p>
 */
public class HorizontalDividerRecyclerViewItemDecoration extends RecyclerView.ItemDecoration {

    private final Drawable dividerDrawable;
    private final int dividerHeightPixels;

    /**
     * <p>Constructor.</p>
     *
     * @param dividerColor the color value to apply to the divider.
     * @param dividerHeightPixels the height to apply to the divider.
     */
    public HorizontalDividerRecyclerViewItemDecoration(int dividerColor, int dividerHeightPixels) {
        this.dividerDrawable = new ColorDrawable(dividerColor);
        this.dividerHeightPixels = dividerHeightPixels;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + dividerHeightPixels;

            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(c);
        }
    }
}