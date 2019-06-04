package com.zoopark.indicator.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.zoopark.indicator.base.BaseIndicator;

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
