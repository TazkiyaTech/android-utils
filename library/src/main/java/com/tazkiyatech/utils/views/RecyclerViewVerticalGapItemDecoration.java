package com.tazkiyatech.utils.views;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * An extension of {@link RecyclerView.ItemDecoration} that
 * draws a vertical gap between each item in a {@link RecyclerView}.
 * <p>
 * Unlike the {@link androidx.recyclerview.widget.DividerItemDecoration} class offered by the
 * <a href="https://maven.google.com/web/index.html#androidx.recyclerview:recyclerview">recyclerview</a>
 * library, this class does not draw a vertical gap under the final item in the {@link RecyclerView}.
 * <p>
 * See <a href="https://stackoverflow.com/a/27037230/1071320">this answer</a> in Stack Overflow
 * for a better understanding of {@link RecyclerView.ItemDecoration}.
 */
public class RecyclerViewVerticalGapItemDecoration extends RecyclerView.ItemDecoration {

    private final int verticalGapInPixels;

    /**
     * Constructor.
     *
     * @param verticalGapInPixels The height of the vertical gap (in pixels).
     */
    public RecyclerViewVerticalGapItemDecoration(int verticalGapInPixels) {
        this.verticalGapInPixels = verticalGapInPixels;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        RecyclerView.Adapter<?> adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;

        int itemPosition = parent.getChildLayoutPosition(view);

        if (itemPosition + 1 < itemCount) {
            outRect.set(0, 0, 0, verticalGapInPixels);
        } else { // this is the last item in the RecyclerView so don't add vertical space underneath it
            outRect.set(0, 0, 0, 0);
        }
    }
}
