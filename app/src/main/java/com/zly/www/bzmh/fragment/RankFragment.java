package com.zly.www.bzmh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zly.www.bzmh.R;
import com.zly.www.bzmh.base.BaseFragment;

/**
 * Created by zly on 2016/3/21.
 * 排行
 */
public class RankFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setToolbarTitle("排行榜");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_rank,container,false);
    }

}
