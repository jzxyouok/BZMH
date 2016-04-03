package com.zly.www.bzmh.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.zly.www.bzmh.R;
import com.zly.www.bzmh.adapter.DrawerAdapter;
import com.zly.www.bzmh.base.BaseActivity;
import com.zly.www.bzmh.fragment.HomeFragment;
import com.zly.www.bzmh.fragment.RankFragment;
import com.zly.www.bzmh.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @Bind(R.id.rv_drawer)
    RecyclerView rvDrawer;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //toolbar初始化
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerlayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        );
        actionBarDrawerToggle.syncState();
        drawerlayout.setDrawerListener(actionBarDrawerToggle);

        //抽屉初始化
        DrawerAdapter drawerAdapter = new DrawerAdapter();
        drawerAdapter.setOnItemClickListener(new MyOnItemClickListener());
        rvDrawer.setLayoutManager(new LinearLayoutManager(this));
        rvDrawer.setAdapter(drawerAdapter);

        replaceFragment(R.id.fl_container, new HomeFragment());
    }

    /**
     * drawer item 点击事件
     */
    public class MyOnItemClickListener implements DrawerAdapter.OnItemClickListener {

        @Override
        public void itemClick(DrawerAdapter.DrawerItemNormal drawerItemNormal) {
            switch (drawerItemNormal.titleRes) {
                case R.string.drawer_menu_home://首页
                    replaceFragment(R.id.fl_container, new HomeFragment());
                    break;
                case R.string.drawer_menu_rank://排行榜
                    replaceFragment(R.id.fl_container, new RankFragment());
                    break;
                case R.string.drawer_menu_column://栏目
                    break;
                case R.string.drawer_menu_search://搜索
                    break;
                case R.string.drawer_menu_setting://设置
                    break;
                case R.string.drawer_menu_night://夜间模式
                    break;
                case R.string.drawer_menu_offline://离线
                    break;
            }
            drawerlayout.closeDrawer(GravityCompat.START);
        }
    }

    public void replaceFragment(int id, Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }

    private long clickTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (SystemClock.uptimeMillis() - clickTime > 1500) {
                clickTime = SystemClock.uptimeMillis();
                ToastUtil.showShort("再次点击退出");
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


}
