package com.zly.www.bzmh.base;

import android.app.Fragment;
import android.os.Bundle;

import com.zly.www.bzmh.utils.NetUtils;
import com.zly.www.bzmh.utils.ToastUtil;


/**
 * Author: zhuliyuan
 * Time: 上午 10:58
 */

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * 加载失败
     */
    public void loadFail(String msg){
        ToastUtil.showShort(msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        NetUtils.cancelRequest(this);
    }
}
