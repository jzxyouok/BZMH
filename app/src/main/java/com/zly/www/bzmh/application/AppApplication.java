package com.zly.www.bzmh.application;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zly.www.bzmh.utils.MLog;

/**
 * Author: zhuliyuan
 * Time: 下午 4:00
 */

public class AppApplication extends Application{
    private static AppApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        Fresco.initialize(context);//Fresco初始化
    }

    public static Context getContext(){
        return context;
    }

}
