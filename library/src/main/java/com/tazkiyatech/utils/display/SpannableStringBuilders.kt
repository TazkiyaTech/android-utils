package com.tazkiyatech.utils.display

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.BulletSpan
import androidx.annotation.ColorInt

/**
 * Appends each [String] in [paragraphs] to this [SpannableStringBuilder]
 * and styles each [String] as a bullet point.
 *
 * @param paragraphs the [Array] of [String]s to append to this [SpannableStringBuilder].
 * @param wantVerticalSpaceBeforeFirstParagraph whether to place some vertical space before the first paragraph.
 * @param verticalSpaceToPutBetweenParagraphs the vertical space, in pixels, to place between each paragraph. Pass in 0 for no extra space.
 * @param horizontalSpaceToPutBetweenBulletPointAndParagraph the horizontal space, in pixels, to place between the bullet point and the paragraph.
 * @param bulletPointColor the bullet point color, as a color integer.
 * @return this [SpannableStringBuilder].
 */
fun SpannableStringBuilder.appendBulletSpans(
    paragraphs: Array<String>,
    wantVerticalSpaceBeforeFirstParagraph: Boolean,
    verticalSpaceToPutBetweenParagraphs: Int,
    horizontalSpaceToPutBetweenBulletPointAndParagraph: Int,
    @ColorInt bulletPointColor: Int
): SpannableStringBuilder {
    var isFirstItem = true

    for (paragraph in paragraphs) {
        val spaceToPutBeforeBulletSpan =
            if (isFirstItem && !wantVerticalSpaceBeforeFirstParagraph) 0 else verticalSpaceToPutBetweenParagraphs

        appendBulletSpan(
            paragraph,
            spaceToPutBeforeBulletSpan,
            horizontalSpaceToPutBetweenBulletPointAndParagraph,
            bulletPointColor
        )

        isFirstItem = false
    }

    return this
}

/**
 * Appends [paragraph] to this [SpannableStringBuilder] and styles it as a bullet point.
 *
 * @param paragraph the [String] to append to this [SpannableStringBuilder].
 * @param verticalSpaceToPutBeforeParagraph the vertical space, in pixels, to place before the paragraph. Pass in 0 for no extra space.
 * @param horizontalSpaceToPutBetweenBulletPointAndParagraph the horizontal space, in pixels, to place between the bullet point and the paragraph.
 * @param bulletPointColor the bullet point color, as a color integer.
 * @return this [SpannableStringBuilder].
 */
fun SpannableStringBuilder.appendBulletSpan(
    paragraph: String,
    verticalSpaceToPutBeforeParagraph: Int,
    horizontalSpaceToPutBetweenBulletPointAndParagraph: Int,
    @ColorInt bulletPointColor: Int
): SpannableStringBuilder {
    val absoluteSizeSpan = AbsoluteSizeSpan(verticalSpaceToPutBeforeParagraph)

    val lengthBeforeAddingAbsoluteSizeSpan = length

    append("\n\n")

    val lengthAddingAddingAbsoluteSizeSpan = length

    setSpan(
        absoluteSizeSpan,
        lengthBeforeAddingAbsoluteSizeSpan,
        lengthAddingAddingAbsoluteSizeSpan,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )

    val bulletSpan =
        BulletSpan(horizontalSpaceToPutBetweenBulletPointAndParagraph, bulletPointColor)

    val lengthBeforeAddingBulletSpan = length

    append(paragraph)

    val lengthAfterAddingBulletSpan = length

    setSpan(
        bulletSpan,
        lengthBeforeAddingBulletSpan,
        lengthAfterAddingBulletSpan,
        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )

    return this
}