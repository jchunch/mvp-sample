package com.jchunch.mvpsample.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * Created by john.hunchar on 1/23/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public void setViewFlipperChildByResId(ViewFlipper viewFlipper, Integer resId) {
        if (viewFlipper == null || resId == null) {
            return;
        }

        for (int i = 0; i < viewFlipper.getChildCount(); i++) {
            View view = viewFlipper.getChildAt(i);
            if (resId == view.getId()) {
                viewFlipper.setDisplayedChild(i);
                return;
            }
        }
    }
}
