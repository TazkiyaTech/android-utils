package com.thinkincode.utils.views;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.thinkincode.utils.BaseTestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Unit tests for the {@link AutoResizeTextView} class.
 */
@RunWith(AndroidJUnit4.class)
@Ignore("TODO: fix failing tests")
public class AutoResizeTextViewTest extends BaseTestCase {

    private static final float MINIMUM_TEXT_SIZE_SP = 12.0f;
    private static final CharSequence TEXT = "Some text";

    private AutoResizeTextView textView;
    private float minimumTextSizePixels;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        textView = new AutoResizeTextView(getContext());
        textView.setMinTextSize(MINIMUM_TEXT_SIZE_SP);
        textView.setText(TEXT);

        minimumTextSizePixels = textView.convertSpToPx(MINIMUM_TEXT_SIZE_SP);
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtStartAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.addEllipsisIfNeeded(30, 65, minimumTextSizePixels, 30.0f);

        // Then.
        assertEquals(TEXT, textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtStartAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.addEllipsisIfNeeded(30, 65, minimumTextSizePixels, 60.0f);

        // Then.
        assertEquals(AutoResizeTextView.ELLIPSIS + "text", textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtStartAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.addEllipsisIfNeeded(30, 20, minimumTextSizePixels, 60.0f);

        // Then.
        assertEquals(AutoResizeTextView.ELLIPSIS, textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtMiddleAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.addEllipsisIfNeeded(30, 68, minimumTextSizePixels, 30.0f);

        // Then.
        assertEquals(TEXT, textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtMiddleAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.addEllipsisIfNeeded(30, 68, minimumTextSizePixels, 60.0f);

        // Then.
        assertEquals("So" + AutoResizeTextView.ELLIPSIS + "xt", textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtMiddleAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.addEllipsisIfNeeded(30, 20, minimumTextSizePixels, 60.0f);

        // Then.
        assertEquals(AutoResizeTextView.ELLIPSIS, textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtEndAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.addEllipsisIfNeeded(30, 80, minimumTextSizePixels, 30.0f);

        // Then.
        assertEquals(TEXT, textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtEndAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.addEllipsisIfNeeded(30, 80, minimumTextSizePixels, 60.0f);

        // Then.
        assertEquals("Some" + AutoResizeTextView.ELLIPSIS, textView.getText());
    }

    @Test
    public void testAddEllipsisIfNeededWhenEllipsizeIsTruncateAtEndAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.addEllipsisIfNeeded(30, 20, minimumTextSizePixels, 60.0f);

        // Then.
        assertEquals(AutoResizeTextView.ELLIPSIS, textView.getText());
    }
}
