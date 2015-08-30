package com.kevin.colorpicker.ui.app;

import android.content.Intent;
import android.os.Bundle;

import com.kevin.colorpicker.R;
import com.kevin.colorpicker.ui.main.MainActivity;
import com.kevin.colorpicker.ui.widget.ShimmerFrameLayout;

import butterknife.Bind;

public class StartActivity extends BaseActivity {

    @Bind(R.id.shimmer_layout)
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
        mShimmerLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

}
