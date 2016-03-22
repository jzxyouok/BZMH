package com.zly.www.bzmh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zly.www.bzmh.R;
import com.zly.www.bzmh.base.BaseFragment;

/**
 * Created by zly on 2016/3/21.
 * 首页
 */
public class HomeFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home,container,false);
    }


}
