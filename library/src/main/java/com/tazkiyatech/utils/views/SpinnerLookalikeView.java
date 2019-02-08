package com.tazkiyatech.utils.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.tazkiyatech.utils.R;

/**
 * A custom view that extends {@link FrameLayout} and looks like a {@link Spinner}.
 * <p>
 * TODO: add override of Spinner class that allows setting of text size and ellipsize.
 * <p>
 * TODO: add attributes to set text, text size and ellipsize via layout xml.
 */
public class SpinnerLookalikeView extends FrameLayout {

	private ViewGroup rootView;
	private TextView textView;

	/**
	 * Constructor to use when creating View from code.
	 * */
    public SpinnerLookalikeView(Context context) {
        super(context);
        initialise();
    }

    /**
     * Constructor that is used when inflating View from XML.
     * */
    public SpinnerLookalikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise();
    }

    /**
     * Constructor that is used when inflating View from XML and applying a class-specific base style.
     * */
	public SpinnerLookalikeView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialise();
	}

	@Override
	public void setOnClickListener(OnClickListener listener) {
		rootView.setOnClickListener(listener);
	}

	/**
	 * @return the text contained in this view.
     * @see TextView#getText()
	 */
	public CharSequence getText() {
		return textView.getText();
	}

	/**
	 * Sets the text to show in this view.
	 * 
	 * @param text the text to show in this view.
     * @see TextView#setText(CharSequence)
	 */
	public void setText(CharSequence text) {
		textView.setText(text);
	}

    /**
     * @return the position where the text should be ellipsized if it does not fit within this view's available height and width.
     * @see TextView#getEllipsize()
     */
    public TextUtils.TruncateAt getTextEllipsize() {
        return textView.getEllipsize();
    }

    /**
     * Sets the position where the text should be ellipsized if it does not fit within this view's available height and width.
     *
     * @param where the position where the text should be ellipsized if it does not fit within this view's available height and width.
     * @see TextView#setEllipsize(TextUtils.TruncateAt)
     */
    public void setTextEllipsize(TextUtils.TruncateAt where) {
        textView.setEllipsize(where);
    }

    /**
     * @return the size of the text contained in this view (in pixels).
     * @see TextView#getTextSize()
     */
    public float getTextSize() {
        return textView.getTextSize();
    }

    /**
     * Sets the desired size of the text contained in this view.
     *
     * @param size the desired size (in "scaled pixel" units) of the text contained in this view.
     * @see TextView#getTextSize()
     */
    public void setTextSize(float size) {
        textView.setTextSize(size);
    }

    /**
     * Sets the desired size of the text contained in this view.
     *
     * @param unit the desired dimension unit.
     * @param size the desired size in the given units.
     * @see TextView#setTextSize(int, float)
     */
    public void setTextSize(int unit, float size) {
        textView.setTextSize(unit, size);
    }

	/**
	 * Initialisation method to be called by the constructors of this class only.
	 */
	private void initialise() {
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.spinner_lookalike, this);

		rootView = (ViewGroup) findViewById(R.id.view_root);
		textView = (TextView) findViewById(R.id.view_text);
	}
}
