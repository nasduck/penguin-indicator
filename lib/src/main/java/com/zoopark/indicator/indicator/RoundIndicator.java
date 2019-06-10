package com.zoopark.indicator.indicator;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.zoopark.indicator.base.BaseIndicator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RoundIndicator extends BaseIndicator implements ViewPager.OnPageChangeListener {

    private ViewPager mViewpager;

    public RoundIndicator(Context context) {
        super(context);
    }

    public RoundIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RoundIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setViewPager(ViewPager viewPager) {
        mViewpager = viewPager;
        mLastPosition = -1;
        initIndicators();
        mViewpager.removeOnPageChangeListener(this);
        mViewpager.addOnPageChangeListener(this);
        this.onPageSelected(mViewpager.getCurrentItem());
    }

    public void initIndicators() {
        removeAllViews();
        if (isViewPagerInit(mViewpager)) {
            createIndicators(mViewpager.getAdapter().getCount(), mViewpager.getCurrentItem());
        }
    }

    @IntDef({View.VISIBLE, View.INVISIBLE, View.GONE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorVisibility{}

    public void setIndicatorVisiable(int index, @IndicatorVisibility int visibility) {
        if (index >= 0 && index <= getChildCount() - 1) {
            final View childView = getChildAt(index);
            childView.setVisibility(visibility);
        }
    }

    //* Private **********************************************************************************//

    private boolean isViewPagerInit(ViewPager viewPager) {
        return viewPager.getAdapter() != null && viewPager.getAdapter().getCount() > 0;
    }

    //* OnPageChangeListener *********************************************************************//

    @Override
    public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {

    }

    @Override
    public void onPageSelected(int pos) {
        if (isViewPagerInit(mViewpager)) {
            selectIndicator(pos);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
