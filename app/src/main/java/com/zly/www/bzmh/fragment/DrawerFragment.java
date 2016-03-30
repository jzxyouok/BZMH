package com.zly.www.bzmh.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zly.www.bzmh.R;
import com.zly.www.bzmh.adapter.DrawerAdapter;
import com.zly.www.bzmh.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zly on 2016/3/21.
 * 首页
 */
public class DrawerFragment extends BaseFragment implements DrawerAdapter.OnItemClickListener {
    @Bind(R.id.rv)
    RecyclerView rv;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_drawer, container, false);
        ButterKnife.bind(this, view);
        context = getActivity();
        init();
        return view;
    }

    private void init() {
        rv.setLayoutManager(new LinearLayoutManager(context));
        DrawerAdapter drawerAdapter = new DrawerAdapter(context,rv);
        drawerAdapter.inflaterHeader(R.layout.item_drawer_header);
        drawerAdapter.setOnItemClickListener(this);
        rv.setAdapter(drawerAdapter);

    }


    @Override
    public void itemClick(View v) {

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
