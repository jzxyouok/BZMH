package com.zly.www.bzmh.utils;

import android.widget.Toast;

import com.zly.www.bzmh.application.AppApplication;


/**
 * Created by zly on 2015/11/30.
 */
public class ToastUtil {

    /**
     * 长Toast
     * @param msg
     */
    public static void showShort(String msg) {
        Toast.makeText(AppApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短Toast
     * @param msg
     */
    public static void showLong(String msg) {
        Toast.makeText(AppApplication.getContext(), msg, Toast.LENGTH_LONG).show();
    }

}
