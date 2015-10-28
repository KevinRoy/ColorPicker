package com.kevin.colorpicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.kevin.colorpicker.widget.waterwave.WaterWave;

/**
 * Created by kevin on 15/9/1.
 */
public class WaterWaveLayout extends LinearLayout {

    private WaterWave waterWave;

    public WaterWaveLayout(Context context) {
        this(context, null, 0);
    }

    public WaterWaveLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaterWaveLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(VERTICAL);
        addView(waterWave = new WaterWave(context, attrs));
    }

    /**
     * 设置水深的刻度
     *
     * @param progress
     */
    public void setProgress(int progress) {
        waterWave.setProgress(progress);
    }

    /**
     * 浪尖颜色
     *
     * @param color
     */
    public void setAboveWaveColor(int color) {
        waterWave.setAboveWaveColor(color);
    }

    /**
     * 浪底颜色
     *
     * @param color
     */
    public void setBlowWaveColor(int color) {
        waterWave.setBlowWaveColor(color);
    }
}
