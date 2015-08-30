package com.kevin.colorpicker.ui.main;

import android.os.Bundle;

import com.kevin.colorpicker.R;
import com.kevin.colorpicker.ui.app.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
    }
}
