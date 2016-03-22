package com.zly.www.bzmh.utils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Map;

/**
 * Author: zhuliyuan
 * Time: 下午 3:20
 */

public class GsonRequest<T> extends Request<T> {

    private final Response.Listener<T> mListener;
    private final Class<T> clazz;
    private final Map<String, String> dataMap;
    private final Gson gson;

    public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> dataMap, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
        this.clazz = clazz;
        this.dataMap = dataMap;
        this.gson = new Gson();
    }

    public GsonRequest(String url, Class<T> clazz, Map<String, String> dataMap, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this((dataMap == null || dataMap.size() == 0) ? Method.GET : Method.POST, url, clazz, dataMap, listener, errorListener);
    }

    //发送参数
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return dataMap;
    }



    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            MLog.i(parsed);//打印获取的数据
            T t = null;
            try {
                t = gson.fromJson(parsed, clazz);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
            return Response.success(t, HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(new VolleyError(e));
        }


    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }


    private final static int initialTimeoutMs = 10 * 1000;//超时时间
    private final static int maxNumRetries = 1;//重新尝试次数

    /**
     * 设置超时重新连接次数
     *
     * @return
     */
    @Override
    public RetryPolicy getRetryPolicy() {
        DefaultRetryPolicy defaultRetryPolicy = new DefaultRetryPolicy(
                initialTimeoutMs,
                maxNumRetries,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );
        return defaultRetryPolicy;
    }
}
