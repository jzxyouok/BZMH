package com.zly.www.bzmh.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zly.www.bzmh.utils.NetUtils;
import com.zly.www.bzmh.utils.ToastUtil;


/**
 * Author: zhuliyuan
 * Time: 下午 5:27
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 加载失败
     */
    public void loadFail(String msg){
        ToastUtil.showShort(msg);
    }

    /**
     * 取消请求
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetUtils.cancelRequest(this);
    }
}
