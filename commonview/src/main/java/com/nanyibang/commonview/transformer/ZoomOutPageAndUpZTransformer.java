package com.nanyibang.commonview.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;


public class ZoomOutPageAndUpZTransformer implements ViewPager.PageTransformer {

    private static final String TAG = "ZoomOutPageAndUpZTransformer";

    public static final float MIN_SCALE = 0.85f;
    private static final float MAX_Z = 28;
    public static final float MIN_Z = 2;


    @Override
    public void transformPage(View view, float position) {


        if (position < -1 || position > 1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);


        } else //a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
        { // [-1,1]
            float factor = 1 - Math.abs(position);

            float scaleFactor = (1 - MIN_SCALE) * factor + MIN_SCALE;
            float elevationFactor = (MAX_Z - MIN_Z) * factor + MIN_Z;

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.

        }
    }
}
