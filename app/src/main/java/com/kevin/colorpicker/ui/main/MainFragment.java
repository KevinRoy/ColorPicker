package com.kevin.colorpicker.ui.main;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.kevin.colorpicker.R;
import com.kevin.colorpicker.ui.app.BaseFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    public static final String IMAGE_TYPE = "image/*";
    public static final int FROM_MOBILE_REQUEST_CODE = 0;

    @InjectView(R.id.image_picker)
    ImageView mImagePicker;
    @InjectView(R.id.image_color)
    ImageView mImageColor;
    @InjectView(R.id.image_text)
    TextView mImageText;
    @InjectView(R.id.take_photo)
    FloatingActionButton mTakePhoto;
    @InjectView(R.id.from_mobile)
    FloatingActionButton mFromMobile;

    private Uri photoUri;

    @OnClick(R.id.take_photo)
    void takePhoto() {

    }

    @OnClick(R.id.from_mobile)
    void fromMobile() {
        Intent intent = new Intent();
        intent.setType(IMAGE_TYPE);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select_picture"), FROM_MOBILE_REQUEST_CODE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            default:
                super.onActivityResult(requestCode, resultCode, data);
            case FROM_MOBILE_REQUEST_CODE:
                if (resultCode == getActivity().RESULT_OK) {
                    if (data == null || data.getData() == null)
                        return;

                    photoUri = data.getData();
                    ImageLoader.getInstance().displayImage(
                            photoUri.toString(),
                            mImagePicker,
                            new DisplayImageOptions.Builder()
                                    .cacheInMemory(true)
                                    .build()
                    );
                }
                break;
        }
    }
}
