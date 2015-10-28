package com.kevin.colorpicker.ui.main;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.kevin.colorpicker.R;
import com.kevin.colorpicker.ui.app.BaseFragment;
import com.kevin.colorpicker.utils.ColorUtil;
import com.kevin.colorpicker.utils.RalColor;
import com.kevin.colorpicker.utils.StringUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    public static final String IMAGE_TYPE = "image/*";

    public static final int FROM_GALLERY_REQUEST_CODE = 0;
    public static final int FROM_CAMERA_REQUEST_CODE = 1;

    @Bind(R.id.image_picker)
    ImageView mImagePicker;
    @Bind(R.id.image_color)
    ImageView mImageColor;
    @Bind(R.id.image_color_text)
    TextView mImageText;

    private Uri photoUri;
    private RalColor ralColor = null;
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    int color;

                    try {
                        color = ColorUtil.findColor(v, x, y);
                    } catch (NullPointerException e) {
                        return false;
                    }

                    if (ralColor == null) {
                        ralColor = new RalColor(color);
                    } else {
                        ralColor.setColor(color);
                    }

                    updateColorData();

                    break;
            }

            return false;
        }
    };

    @OnClick(R.id.fb_camera)
    void camera() {

    }

    @OnClick(R.id.fb_gallery)
    void gallery() {
        Intent intent = new Intent();
        intent.setType(IMAGE_TYPE);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select_picture"), FROM_GALLERY_REQUEST_CODE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            default:
                super.onActivityResult(requestCode, resultCode, data);
            case FROM_GALLERY_REQUEST_CODE:
                if (resultCode == getActivity().RESULT_OK) {
                    if (data == null || data.getData() == null)
                        return;

                    photoUri = data.getData();
                }
                break;
        }
    }

    private void initView() {
        if (mImagePicker != null) {
            ViewTreeObserver viewTreeObserver = mImagePicker.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mImagePicker.setOnTouchListener(onTouchListener);
                }
            });
        }
    }

    /**
     *
     */
    private void updateColorData() {
        int index = ralColor.getIndex();
        int red = Color.red(ralColor.getColor());
        int green = Color.green(ralColor.getColor());
        int blue = Color.blue(ralColor.getColor());

        mImageColor.setBackgroundColor(ralColor.getColor());
        mImageText.setText("#".concat(StringUtil.ConcatString(Integer.toHexString(red)))
                .concat(StringUtil.ConcatString(Integer.toHexString(green)))
                .concat(StringUtil.ConcatString(Integer.toHexString(blue))));
    }
}
