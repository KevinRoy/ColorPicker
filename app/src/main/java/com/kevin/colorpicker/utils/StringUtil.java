package com.kevin.colorpicker.utils;

/**
 * Created by kevin on 15/10/26.
 */
public class StringUtil {

    public static String ConcatString(String concatString) {
        if (concatString.length() < 2) {
            return "0".concat(concatString);
        } else {
            return concatString;
        }
    }
}
