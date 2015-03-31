package com.kevin.colorpicker.ui.app;

import android.os.Bundle;

import com.kevin.colorpicker.R;
import com.kevin.colorpicker.ui.widget.ShimmerFrameLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class StartActivity extends BaseActivity {

    @InjectView(R.id.shimmer_layout)
    ShimmerFrameLayout mShimmerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mShimmerLayout.startShimmerAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mShimmerLayout.stopShimmerAnimation();
    }

    private void initView() {
        mShimmerLayout.useDefaults();
    }

}
