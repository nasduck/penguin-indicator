package com.duck.penguinindicator.demo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.duck.penguinindicator.indicator.RoundIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private RoundIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);
        mIndicator = findViewById(R.id.indicator);

        mViewPager.setAdapter(new DemoPagerAdapter());
        mIndicator.setViewPager(mViewPager);
    }
}
