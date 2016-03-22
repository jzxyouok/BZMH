package com.zly.www.bzmh.manager;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zly.www.bzmh.bean.WeatherBean;
import com.zly.www.bzmh.utils.GsonRequest;
import com.zly.www.bzmh.utils.NetUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取天气数据管理类
 * 数据全部在这里处理
 * Created by zly on 2015/11/30.
 */
public class WeatherManager {

    /**
     * 包装天气请求参数
     * @return 返回包装好的参数
     */
    public Map<String,String> getRequestParams(){
        Map<String,String> dataMap = new HashMap<>();
        return dataMap;
    }

    /**
     * 发送请求
     * @param listener activity中回调监听
     * @param activity request的tag标记
     */
    public void queryWeather(final WeatherDataListener listener,Activity activity) {
        NetUtils.addRequest(new GsonRequest<WeatherBean>(
                Request.Method.POST,
                "http://www.weather.com.cn/data/sk/101010100.html",
                WeatherBean.class,
                null,
                new Response.Listener<WeatherBean>() {
                    @Override
                    public void onResponse(WeatherBean response) {
                        if (response.isSuccess()) {
                            listener.weatherSuccess(response);
                        } else {
                            listener.weatherFail(TextUtils.isEmpty(response.message) ? "获取天气数据失败" : response.message);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("test", error.getMessage());
                    }
                }
        ), activity);
    }

    /**
     * 数据回调接口
     */
    public interface WeatherDataListener{
        public abstract void weatherSuccess(WeatherBean weatherBean);

        public abstract void weatherFail(String msg);
    }
}
