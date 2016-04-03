package com.zly.www.bzmh.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
     * 设置toolbar title
     * @param title
     */
    public void setToolbarTitle(String title){
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        supportActionBar.setTitle(title);
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
