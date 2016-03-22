package com.zly.www.bzmh.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author: zhuliyuan
 * Time: 上午 10:41
 */

public class SPUtils {

    private final static String SPName = "sp_name";

    private static SharedPreferences getSharedPreferences(Context context){
        SharedPreferences sp = context.getSharedPreferences(SPName, Context.MODE_PRIVATE);
        return sp;
    }


    public static void putString(Context context,String key,String value){
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key,value);
        edit.commit();
    }

    public static String getString(Context context,String key,String defValue){
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(key,defValue);
    }

    public static void putBoolean(Context context,String key,boolean value){
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key,value);
        edit.commit();
    }

    public static boolean getBoolean(Context context,String key,boolean defValue){
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(key,defValue);
    }
}
