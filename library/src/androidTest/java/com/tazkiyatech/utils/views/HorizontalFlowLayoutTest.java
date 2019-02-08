package com.tazkiyatech.utils.views;

import android.view.View;
import android.view.ViewGroup;

import com.tazkiyatech.utils.BaseTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit tests for the {@link HorizontalFlowLayout} class.
 */
@RunWith(AndroidJUnit4.class)
public class HorizontalFlowLayoutTest extends BaseTestCase {

    private HorizontalFlowLayout target;

    @Before
    public void setUp() {
        target = new HorizontalFlowLayout(getContext());
    }

    @Test
    public void test_measureRequiredHeight_withEmptyListOfChildViews() {
        // Given.
        int expected = 0;

        // When.
        int actual = target.measureRequiredHeight(100, 0, 0, 0, 0);

        // Then.
        assertThat(actual, is(expected));
    }

    @Test
    public void test_measureRequiredHeight_withNonEmptyListOfChildViews() {
        // Given.

        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(0, 0);
        layoutParams.setMargins(25, 15, 25, 15);

        View view1 = new View(getContext());
        view1.setLayoutParams(new ViewGroup.MarginLayoutParams(layoutParams));

        View view2 = new View(getContext());
        view2.setLayoutParams(new ViewGroup.MarginLayoutParams(layoutParams));

        View view3 = new View(getContext());
        view3.setLayoutParams(new ViewGroup.MarginLayoutParams(layoutParams));

        target.addView(view1);
        target.addView(view2);
        target.addView(view3);

        int expected = 60;

        // When.
        int actual = target.measureRequiredHeight(100, 0, 0, 0, 0);

        // Then.
        assertThat(actual, is(expected));
    }
}
