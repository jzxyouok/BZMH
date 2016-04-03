package com.zly.www.bzmh.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.zly.www.bzmh.R;
import com.zly.www.bzmh.base.BaseFragment;
import com.zly.www.bzmh.utils.MLog;

/**
 * Created by zly on 2016/3/21.
 * 首页
 */
public class HomeFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//fragment中menu可用
        setToolbarTitle("暴走日报");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_msg://消息
                break;
            case R.id.item_refresh://刷新
                break;
            case R.id.item_setting://设置
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
