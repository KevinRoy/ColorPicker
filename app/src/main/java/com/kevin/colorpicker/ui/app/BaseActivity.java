package com.kevin.colorpicker.ui.app;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

public class BaseActivity extends ActionBarActivity {

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.inject(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.inject(this);
    }
}
