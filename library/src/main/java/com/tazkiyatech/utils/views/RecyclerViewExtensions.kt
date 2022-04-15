package com.tazkiyatech.utils.views

import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView

/**
 * Sets the colored divider that will be drawn between each item in the [RecyclerView].
 *
 * Note that this method calls into the [RecyclerView.addItemDecoration] method internally.
 * This call will likely conflict with any other calls to [RecyclerView.addItemDecoration] that you make on the [RecyclerView].
 */
fun RecyclerView.setColoredDivider(@ColorInt dividerColor: Int,
                                   dividerHeightPixels: Int,
                                   dividerMarginLeftPixels: Int = 0,
                                   dividerMarginRightPixels: Int = 0) {
    val itemDecoration = RecyclerViewColoredDividerItemDecoration(
        dividerColor, dividerHeightPixels, dividerMarginLeftPixels, dividerMarginRightPixels
    )
    addItemDecoration(itemDecoration)
}

/**
 * Sets the vertical gap that will be drawn between each item in the [RecyclerView].
 *
 * Note that this method calls into the [RecyclerView.addItemDecoration] method internally.
 * This call will likely conflict with any other calls to [RecyclerView.addItemDecoration] that you make on the [RecyclerView].
 */
fun RecyclerView.setVerticalGap(verticalGapInPixels: Int) {
    addItemDecoration(RecyclerViewVerticalGapItemDecoration(verticalGapInPixels))
}
