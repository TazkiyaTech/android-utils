package com.thinkincode.utils.views;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.thinkincode.utils.BaseTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link AutoResizeTextView} class.
 */
@RunWith(AndroidJUnit4.class)
public class AutoResizeTextViewTest extends BaseTestCase {

    private static final float MAXIMUM_TEXT_SIZE_SP = 18.0f;
    private static final float MINIMUM_TEXT_SIZE_SP = 12.0f;
    private static final String TEST_TEXT = "12345678";

    private AutoResizeTextView textView;

    /**
     * The minimum text size in pixels (rather than scaled pixels).
     */
    private float minimumTextSizePixels;

    /**
     * This is the height of the {@link #TEST_TEXT} String
     * if it were all to fit on one line in {@link #textView}
     * and if the text size of {@link #textView} was {@link #MINIMUM_TEXT_SIZE_SP}.
     */
    private float testTextHeight;

    /**
     * This is the width of the {@link #TEST_TEXT} String
     * if it were all to fit on one line in {@link #textView}
     * and if the text size of {@link #textView} was {@link #MINIMUM_TEXT_SIZE_SP}.
     */
    private float testTextWidth;

    /**
     * This is the height of the {@link AutoResizeTextView#ELLIPSIS} String
     * if it were all to fit on one line in {@link #textView}
     * and if the text size of {@link #textView} was {@link #MINIMUM_TEXT_SIZE_SP}.
     */
    private float ellipsisTextWidth;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        textView = new AutoResizeTextView(getContext());
        textView.setTextSize(MAXIMUM_TEXT_SIZE_SP);
        textView.setMinTextSize(MINIMUM_TEXT_SIZE_SP);
        textView.setText(TEST_TEXT);

        float maximumTextSizePixels = textView.convertSpToPx(MAXIMUM_TEXT_SIZE_SP);
        minimumTextSizePixels = textView.convertSpToPx(MINIMUM_TEXT_SIZE_SP);

        testTextHeight = textView.measureTextHeightPixels(TEST_TEXT, Integer.MAX_VALUE, minimumTextSizePixels);
        testTextWidth = textView.measureTextWidthPixels(TEST_TEXT, minimumTextSizePixels);
        ellipsisTextWidth = textView.measureTextWidthPixels(AutoResizeTextView.ELLIPSIS, minimumTextSizePixels);

        assertThat(textView.getText().toString(), equalTo(TEST_TEXT));
        assertThat(textView.getTextSize(), equalTo(maximumTextSizePixels));
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
        float textHeightPixels = textView.measureTextHeightPixels(TEST_TEXT, Integer.MAX_VALUE, minimumTextSizePixels);

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
        float textWidthPixels = textView.measureTextWidthPixels(TEST_TEXT, minimumTextSizePixels);

        // Then.
        assertThat(textWidthPixels, greaterThan(new Float(0)));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtStartAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.resizeText(((int)testTextWidth)+1, ((int)testTextHeight));

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(TEST_TEXT));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, either(is(minimumTextSizePixels)).or(is(minimumTextSizePixels + 1)));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtStartAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.resizeText(((int)testTextWidth)-1, ((int)testTextHeight)+1);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, startsWith(AutoResizeTextView.ELLIPSIS));
        assertThat(TEST_TEXT, endsWith(text.substring(1)));
        assertThat(text.length(), lessThan(TEST_TEXT.length()));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, equalTo(minimumTextSizePixels));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtStartAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.START);

        // When.
        textView.resizeText(((int)ellipsisTextWidth)+1, ((int)testTextHeight)+1);

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(AutoResizeTextView.ELLIPSIS));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, equalTo(minimumTextSizePixels));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtMiddleAndEllipsizeNotNeeded() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.resizeText(((int)testTextWidth)+1, ((int)testTextHeight));

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(TEST_TEXT));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, either(is(minimumTextSizePixels)).or(is(minimumTextSizePixels + 1)));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtMiddleAndEllipsizeNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.resizeText(((int)testTextWidth)-1, ((int)testTextHeight)+1);

        // Then.
        String text = textView.getText().toString();

        assertThat(text, containsString(AutoResizeTextView.ELLIPSIS));
        assertThat(text.length(), lessThan(TEST_TEXT.length()));

        // And.
        String[] textSplitOnEllipsis = text.split(AutoResizeTextView.ELLIPSIS);

        assertThat(TEST_TEXT, startsWith(textSplitOnEllipsis[0]));
        assertThat(TEST_TEXT, endsWith(textSplitOnEllipsis[1]));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, equalTo(minimumTextSizePixels));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtMiddleAndEllipsizeNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);

        // When.
        textView.resizeText(((int)ellipsisTextWidth)+1, ((int)testTextHeight)+1);

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(AutoResizeTextView.ELLIPSIS));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, equalTo(minimumTextSizePixels));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtEndAndEllipsizeNotNeeded_1() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.resizeText(((int)testTextWidth)+1, ((int)testTextHeight));

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(TEST_TEXT));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, either(is(minimumTextSizePixels)).or(is(minimumTextSizePixels + 1)));
    }

    @Test
    public void test_resizeText_whenEllipsizeIsTruncateAtEndAndEllipsizeNotNeeded_2() {
        // Given.
        textView.setEllipsize(TextUtils.TruncateAt.END);

        // When.
        textView.resizeText((int)((testTextWidth/2)+1), (int)(testTextHeight*2));

        // Then.
        String text = textView.getText().toString();
        assertThat(text, equalTo(TEST_TEXT));

        // And.
        float textSize = textView.getTextSize();
        assertThat(textSize, either(is(minimumTextSizePixels)).or(is(minimumTextSizePixels + 1)));
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
        assertThat(TEST_TEXT, startsWith(text.substring(0, text.length()-1)));
        assertThat(text.length(), lessThan(TEST_TEXT.length()));

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
