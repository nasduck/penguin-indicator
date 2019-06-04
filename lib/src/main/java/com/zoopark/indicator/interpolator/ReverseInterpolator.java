package com.zoopark.indicator.interpolator;

import android.view.animation.Interpolator;

public class ReverseInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float value) {
        return Math.abs(1.0f - value);
    }

}
