package com.thinkincode.utils.views;

import android.content.Context;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * <p>An extension of TextView which resizes (scales down) its text to fit within its available width and height.</p>
 * 
 * <p>This view is a modification of Chase's answer on Stack Overflow here:
 * <a href="http://stackoverflow.com/a/5535672/1071320" >http://stackoverflow.com/a/5535672/1071320</a></p>
 */
public class AutoResizeTextView extends TextView {

    /**
     * <p>Our ellipsis string.</p>
     * 
     * <p>(Default package-private visibility for unit-tests access.)</p>
     * */
    static final String ELLIPSIS = "\u2026";

    /** Upper bounds for text size. This acts as a starting point for resizing. */
    private float mMaxTextSizePixels;

    /** Lower bounds for text size. */
    private float mMinTextSizePixels;

    /** TextView line spacing multiplier. */
    private float mLineSpacingMultiplier = 1.0f;

    /** TextView additional line spacing. */
    private float mLineSpacingExtra = 0.0f;

    /**
     * Default constructor override.
     * 
     * @param context
     */
    public AutoResizeTextView(Context context) {
        this(context, null);
        initialise();
    }

    /**
     * Default constructor when inflating from XML file.
     * 
     * @param context
     * @param attrs
     */
    public AutoResizeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initialise();
    }

    /**
     * Default constructor override.
     * 
     * @param context
     * @param attrs
     * @param defStyle
     */
    public AutoResizeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    	super.onLayout(changed, left, top, right, bottom);
    	resizeText();
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
    	super.onTextChanged(text, start, lengthBefore, lengthAfter);
        requestLayout();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    	super.onSizeChanged(w, h, oldw, oldh);

        if (w != oldw || h != oldh) {
            requestLayout();
        }
    }

    @Override
    public void setTextSize(float size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    @Override
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        mMaxTextSizePixels = getTextSize();
        requestLayout();
    }

    @Override
    public void setLineSpacing(float add, float mult) {
        super.setLineSpacing(add, mult);
        mLineSpacingMultiplier = mult;
        mLineSpacingExtra = add;
        requestLayout();
    }

    @Override
    public void setEllipsize(TruncateAt where) {
    	super.setEllipsize(where);
    	requestLayout();
    }

    /**
     * Sets the lower text size limit and invalidates the view.
     * 
     * @param minTextSizeScaledPixels the minimum size to use for text in this view, in scaled pixels.
     */
    public void setMinTextSize(float minTextSizeScaledPixels) {
        mMinTextSizePixels = convertSpToPx(minTextSizeScaledPixels);
        requestLayout();
    }

    /**
     * @return lower text size limit, in pixels.
     */
    public float getMinTextSizePixels() {
    	return mMinTextSizePixels;
    }

    private void initialise() {
    	mMaxTextSizePixels = getTextSize();
    }

    /**
     * Resizes this view's text size with respect to its width and height (minus padding).
     */
    private void resizeText() {
        final int availableHeightPixels = getHeight() - getCompoundPaddingBottom() - getCompoundPaddingTop();
        final int availableWidthPixels = getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();

        final CharSequence text = getText();

        // Safety check! Do not resize if the view does not have dimensions or if there is no text
        if (text == null || text.length() == 0 || availableHeightPixels <= 0 || availableWidthPixels <= 0 || mMaxTextSizePixels == 0) {
            return;
        }

        float targetTextSizePixels = mMaxTextSizePixels;
        int targetTextHeightPixels = getTextHeightPixels(text, availableWidthPixels, targetTextSizePixels);

        // Until we either fit within our TextView or we have reached our minimum text size, incrementally try smaller sizes
        while (targetTextHeightPixels > availableHeightPixels && targetTextSizePixels > mMinTextSizePixels) {
            targetTextSizePixels = Math.max(targetTextSizePixels - 2, mMinTextSizePixels);
            targetTextHeightPixels = getTextHeightPixels(text, availableWidthPixels, targetTextSizePixels);
        }

        // Auto-ellipsize doesn't work in this custom TextView hence why we have to do it here...
        addEllipsisIfNeeded(availableHeightPixels, availableWidthPixels, targetTextSizePixels, targetTextHeightPixels);

        super.setTextSize(TypedValue.COMPLEX_UNIT_PX, targetTextSizePixels);
        // Some devices try to auto adjust line spacing, so force default line spacing
        super.setLineSpacing(mLineSpacingExtra, mLineSpacingMultiplier);
    }

    /**
     * Sets the text size of a clone of the view's {@link TextPaint} object and uses a {@link StaticLayout} instance to measure the height of the text.
     * 
     * @param source
     * @param availableWidthPixels
     * @param textSizePixels
     * @return the height of the text when placed in a view with the specified width and when the text has the specified size.
     */
    private int getTextHeightPixels(CharSequence source, int availableWidthPixels, float textSizePixels) {
        // Make a copy of the original TextPaint object
        // since the object gets modified while measuring
    	// (see also the docs for TextView.getPaint() which states to access it read-only)
        TextPaint textPaintCopy = new TextPaint(getPaint());
        textPaintCopy.setTextSize(textSizePixels);

        // Measure using a StaticLayout instance
        StaticLayout staticLayout = new StaticLayout(source, textPaintCopy, availableWidthPixels, Alignment.ALIGN_NORMAL, mLineSpacingMultiplier, mLineSpacingExtra, true);

        return staticLayout.getHeight();
    }

    /**
     * <p>If this TextView has an ellipsize associated to it,
     * the text size is the minimum text size
     * and the text height (over multiple lines) is greater than the available height,
     * then cut the text and add an ellipsis.</p>
     * 
     * <p>(Default package-private visibility for unit-tests access.)</p>
     * 
     * @param availableHeightPixels
     * @param availableWidthPixels
     * @param textSizePixels
     * @param textHeightPixels
     */
    void addEllipsisIfNeeded(int availableHeightPixels, int availableWidthPixels, float textSizePixels, float textHeightPixels) {
    	if (getEllipsize() != null && textSizePixels <= mMinTextSizePixels && textHeightPixels > availableHeightPixels) {
        	if (getEllipsize().equals(TruncateAt.END)) {
        		addEllipsisAtEndOfText(availableHeightPixels, availableWidthPixels, textSizePixels);
        	} else if (getEllipsize().equals(TruncateAt.START)) {
        		addEllipsisAtStartOfText(availableWidthPixels, textSizePixels);
        	} else if (getEllipsize().equals(TruncateAt.MIDDLE)) {
        		addEllipsisAtMiddleOfText(availableWidthPixels, textSizePixels);
        	}
        }
    }

    /**
     * Chops the characters at the end of the text down
     * until it fits within the available height and width
     * at the specified text size...
     * and adds an ellipsis at the end of the chopped text.
     * 
     * @param availableHeightPixels >= 0.
     * @param availableWidthPixels >= 0.
     * @param textSizePixels >= 0.
     */
    private void addEllipsisAtEndOfText(int availableHeightPixels, int availableWidthPixels, float textSizePixels) {
    	// Make a copy of the original TextPaint object for measuring
    	final TextPaint textPaintCopy = new TextPaint(getPaint());
        textPaintCopy.setTextSize(textSizePixels);

        final CharSequence text = getText();

        // safety check
        if (TextUtils.isEmpty(text)) {
        	return;
        }

        // Measure using a StaticLayout instance
        final StaticLayout staticLayout = new StaticLayout(text, textPaintCopy, availableWidthPixels, Alignment.ALIGN_NORMAL, mLineSpacingMultiplier, mLineSpacingExtra, false);

        // Check that we have a least one line of rendered text
        if (staticLayout.getLineCount() <= 0) {
        	return;
        }

        // Since the line at the specific vertical position would be cut off,
        // we must trim up to the previous line and add an ellipsis
        final int lastLineNumber = staticLayout.getLineForVertical(availableHeightPixels) - 1;

        // safety check
        if (lastLineNumber < 0) {
        	return;
        }

        final float ellipsisWidthPixels = textPaintCopy.measureText(ELLIPSIS);

        // safety check
        if (ellipsisWidthPixels > availableWidthPixels) {
        	return;
        }

        final int lastLineStartOffset = staticLayout.getLineStart(lastLineNumber);
        int lastLineEndOffset = staticLayout.getLineEnd(lastLineNumber);

        float choppedLineExcludingEllipsisWidthPixels;

        // Trim characters off until we have enough room to draw the ellipsis
        do {
        	choppedLineExcludingEllipsisWidthPixels = textPaintCopy.measureText(text, lastLineStartOffset, lastLineEndOffset);
        	lastLineEndOffset--;
        } while (choppedLineExcludingEllipsisWidthPixels + ellipsisWidthPixels > availableWidthPixels);

        // add one to 'lastLineEndOffset' since it was just decremented in the do-while loop
        setText(text.subSequence(0, lastLineEndOffset + 1) + ELLIPSIS);
    }

    /**
     * Chops the characters at the beginning of the text down
     * until it fits in a single line within the available width
     * at the specified text size...
     * and adds an ellipsis at the beginning of the chopped text.
     * 
     * @param availableWidthPixels >= 0.
     * @param textSizePixels >= 0.
     */
    private void addEllipsisAtStartOfText(int availableWidthPixels, float textSizePixels) {
    	// Make a copy of the original TextPaint object for measuring
    	final TextPaint textPaintCopy = new TextPaint(getPaint());
        textPaintCopy.setTextSize(textSizePixels);

        final CharSequence text = getText();

        // safety check
        if (TextUtils.isEmpty(text)) {
        	return;
        }

        float ellipsisWidthPixels = textPaintCopy.measureText(ELLIPSIS);

        // safety check
        if (ellipsisWidthPixels > availableWidthPixels) {
        	return;
        }

        final int endOffset = text.length();

        int startOffset = 0;

        CharSequence choppedTextExcludingEllipsis;
        float choppedTextExcludingEllipsisWidthPixels;

        // Trim characters off until we have enough room to draw the ellipsis
        do {
        	choppedTextExcludingEllipsis = text.subSequence(startOffset, endOffset);
        	choppedTextExcludingEllipsisWidthPixels = textPaintCopy.measureText(choppedTextExcludingEllipsis.toString());
        	startOffset++;
        } while (choppedTextExcludingEllipsisWidthPixels + ellipsisWidthPixels > availableWidthPixels);

        setText(ELLIPSIS + choppedTextExcludingEllipsis);
    }

    /**
     * Chops the characters in the middle of the text down
     * until it fits in a single line within the available width
     * at the specified text size...
     * and adds an ellipsis in the middle of the chopped text.
     * 
     * @param availableWidthPixels >= 0.
     * @param textSizePixels >= 0.
     */
    private void addEllipsisAtMiddleOfText(int availableWidthPixels, float textSizePixels) {
    	// Make a copy of the original TextPaint object for measuring
    	final TextPaint textPaintCopy = new TextPaint(getPaint());
        textPaintCopy.setTextSize(textSizePixels);

        final CharSequence text = getText();

        // safety check
        if (TextUtils.isEmpty(text)) {
        	return;
        }
        
        float ellipsisWidthPixels = textPaintCopy.measureText(ELLIPSIS);

        // safety check
        if (ellipsisWidthPixels > availableWidthPixels) {
        	return;
        }

        final int startOffset = 0;
        final int endOffset = text.length();

        int ellipsisStartOffset = (endOffset - startOffset) / 2;
        int ellipsisEndOffset = ellipsisStartOffset + 1;

        CharSequence textLeftOfEllipsis;
        CharSequence textRightOfEllipsis;

        float choppedTextExcludingEllipsisWidthPixels;

        // Trim characters off until we have enough room to draw the ellipsis
        do {
        	textLeftOfEllipsis = text.subSequence(startOffset, ellipsisStartOffset);
        	textRightOfEllipsis = text.subSequence(ellipsisEndOffset, endOffset);

        	float textLeftOfEllipsisWidthPixels = textPaintCopy.measureText(textLeftOfEllipsis.toString());
        	float textRightOfEllipsisWidthPixels = textPaintCopy.measureText(textRightOfEllipsis.toString());

        	choppedTextExcludingEllipsisWidthPixels = textLeftOfEllipsisWidthPixels + textRightOfEllipsisWidthPixels;

        	if ((ellipsisStartOffset - startOffset) > (endOffset - ellipsisEndOffset)) {
        		ellipsisStartOffset--;
        	} else {
        		ellipsisEndOffset++;
        	}
        } while (choppedTextExcludingEllipsisWidthPixels + ellipsisWidthPixels > availableWidthPixels);

        setText(textLeftOfEllipsis + ELLIPSIS + textRightOfEllipsis);
    }

    /**
     * <p>Converts scaled pixels to pixels.</p>
     *
     * <p>(Default package-private visibility for unit-tests access.)</p>
     * 
     * @param scaledPixels
     * @return the number of pixels which <code>scaledPixels</code> corresponds to on the device.
     */
    float convertSpToPx(float scaledPixels) {
    	float pixels = scaledPixels * getContext().getResources().getDisplayMetrics().scaledDensity;
    	return pixels;
    }
}
