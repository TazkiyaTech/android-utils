package com.thinkincode.utils.views;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.thinkincode.utils.BaseTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link AutoResizeTextView} class.
 */
@RunWith(AndroidJUnit4.class)
public class AutoResizeTextViewTest extends BaseTestCase {

    private static final float MAXIMUM_TEXT_SIZE_SP = 18.0f;
    private static final float MINIMUM_TEXT_SIZE_SP = 12.0f;
    private static final String TEXT = "Some text";

    private AutoResizeTextView textView;
    private float minimumTextSizePixels;

    private float testTextHeight;
    private float testTextWidth;
    private float ellipsisTextWidth;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        textView = new AutoResizeTextView(getContext());
        textView.setTextSize(MAXIMUM_TEXT_SIZE_SP);
        textView.setMinTextSize(MINIMUM_TEXT_SIZE_SP);
        textView.setText(TEXT);

        minimumTextSizePixels = textView.convertSpToPx(MINIMUM_TEXT_SIZE_SP);

        testTextHeight = textView.measureTextHeightPixels(TEXT, Integer.MAX_VALUE, minimumTextSizePixels);
        testTextWidth = textView.measureTextWidthPixels(TEXT, minimumTextSizePixels);
        ellipsisTextWidth = textView.measureTextWidthPixels(AutoResizeTextView.ELLIPSIS, minimumTextSizePixels);
    }

    @Test
    public void test_measureTextHeightPixels_whenTextEmpty() {
        // When.
        float textHeightPixels = textView.measureTextHeightPixels("", Integer.MAX_VALUE, minimumTextSizePixels);

        // Then.
        assertThat(textHeightPixels, greaterThan(new Float(0)));
    }

    @Test
    public void test_measureTextHeightPixels_whenTextNonEmpty() {
        // When.
        float textHeightPixels = textView.measureTextHeightPixels(TEXT, Integer.MAX_VALUE, minimumTextSizePixels);

        // Then.
        assertThat(textHeightPixels, greaterThan(new Float(0)));
    }

    @Test
    public void test_measureTextWidthPixels_whenTextEmpty() {
        // When.
        float textWidthPixels = textView.measureTextWidthPixels("", minimumTextSizePixels);

        // Then.
        assertThat(textWidthPixels, equalTo(new Float(0)));
    }

    @Test
    public void test_measureTextWidthPixels_whenTextNonEmpty() {
        // When.
        float textWidthPixels = textView.measureTextWidthPixels(TEXT, minimumTextSizePixels);

        // Then.
        assertThat(textWidthPixels, greaterThan(new Float(0)));
    }

    @Test
    public void test_addEllipsisIfNeeded_whenEllipsizeIsTruncateAtStartAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.addEllipsisIfNeeded(((int)testTextHeight)+1, ((int)testTextWidth)+1, minimumTextSizePixels, testTextHeight);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, equalTo(TEXT));
    }

    @Test
    public void test_addEllipsisIfNeeded_whenEllipsizeIsTruncateAtStartAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.addEllipsisIfNeeded(((int)testTextHeight)+1, ((int)testTextWidth)/2, minimumTextSizePixels, testTextHeight*2);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, startsWith(AutoResizeTextView.ELLIPSIS));
        assertThat(TEXT, endsWith(text.substring(1)));
        assertThat(text.length(), lessThan(TEXT.length()));
    }

    @Test
    public void test_addEllipsisIfNeeded_whenEllipsizeIsTruncateAtStartAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.addEllipsisIfNeeded(((int)testTextHeight)+1, ((int)ellipsisTextWidth)+1, minimumTextSizePixels, testTextHeight*2);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, equalTo(AutoResizeTextView.ELLIPSIS));
    }

    @Test
    public void test_addEllipsisIfNeeded_whenEllipsizeIsTruncateAtMiddleAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.addEllipsisIfNeeded(((int)testTextHeight)+1, ((int)testTextWidth)+1, minimumTextSizePixels, testTextHeight);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, equalTo(TEXT));
    }

    @Test
    public void test_addEllipsisIfNeeded_whenEllipsizeIsTruncateAtMiddleAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.addEllipsisIfNeeded(((int)testTextHeight)+1, ((int)testTextWidth)/2, minimumTextSizePixels, testTextHeight*2);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, containsString(AutoResizeTextView.ELLIPSIS));
        assertThat(text.length(), lessThan(TEXT.length()));

        // And.
        String[] textSplitOnEllipsis = text.split(AutoResizeTextView.ELLIPSIS);

        assertThat(TEXT, startsWith(textSplitOnEllipsis[0]));
        assertThat(TEXT, endsWith(textSplitOnEllipsis[1]));
    }

    @Test
    public void test_addEllipsisIfNeeded_whenEllipsizeIsTruncateAtMiddleAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.addEllipsisIfNeeded(((int)testTextHeight)+1, ((int)ellipsisTextWidth)+1, minimumTextSizePixels, testTextHeight*2);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, equalTo(AutoResizeTextView.ELLIPSIS));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtEndAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.resizeText(((int)testTextWidth)+1, ((int)testTextHeight)+1);

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(TEXT));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, equalTo(minimumTextSizePixels));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtEndAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.resizeText(((int)testTextWidth)-1, ((int)testTextHeight)+1);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, endsWith(AutoResizeTextView.ELLIPSIS));
        assertThat(TEXT, startsWith(text.substring(0, text.length()-1)));
        assertThat(text.length(), lessThan(TEXT.length()));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, equalTo(minimumTextSizePixels));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtEndAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.resizeText(((int)ellipsisTextWidth)+1, ((int)testTextHeight)+1);

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(AutoResizeTextView.ELLIPSIS));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, equalTo(minimumTextSizePixels));
    }
}
