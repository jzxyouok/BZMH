package com.zly.www.bzmh.utils;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.zly.www.bzmh.application.AppApplication;
import com.zly.www.bzmh.bean.BaseBean;

/**
 *
 * Author: zhuliyuan
 * Time: 下午 3:59
 */

public class NetUtils {

    private static RequestQueue requestQueue = Volley.newRequestQueue(AppApplication.getContext());


    private NetUtils() {
    }

    /**
     * 添加请求
     *
     * @param gsonRequest
     * @param tag
     */
    public static void addRequest(GsonRequest<? extends BaseBean> gsonRequest, Object tag) {
        if (tag != null)
            gsonRequest.setTag(tag);

        requestQueue.add(gsonRequest);
    }

    /**
     * 取消请求
     *
     * @param tag
     */
    public static void cancelRequest(Object tag) {
        requestQueue.cancelAll(tag);
    }

}
