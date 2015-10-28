package com.kevin.colorpicker.ui.app;

import android.content.Intent;
import android.os.Bundle;

import com.kevin.colorpicker.R;
import com.kevin.colorpicker.ui.main.MainActivity;
import com.kevin.colorpicker.widget.WaterWaveLayout;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends BaseActivity {

    @Bind(R.id.wave)
    WaterWaveLayout wave;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (i == 3) {
                            timer.cancel();
                            Intent intent = new Intent(StartActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        i++;
                    }
                });
            }
        }, 20, 2000);
    }
}
