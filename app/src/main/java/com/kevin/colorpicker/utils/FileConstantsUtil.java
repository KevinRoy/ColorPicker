package com.kevin.colorpicker.utils;

import android.os.Environment;

/**
 * Created by kevin on 15/11/6.
 */
public class FileConstantsUtil {

    public static final String BASE_FILESDIR = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)
            ? Environment.getExternalStorageDirectory().toString() + "/colorPicker"
            : Environment.getDownloadCacheDirectory().getPath();

    public static final String WORK_FOLDER_PHOTO_TEMP = BASE_FILESDIR + "/photo";

    /**
     * 照相保存的路径
     */
    public static final String IMG_PATH = WORK_FOLDER_PHOTO_TEMP + "/temp.jpg";
}
