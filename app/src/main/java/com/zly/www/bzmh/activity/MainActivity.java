package com.zly.www.bzmh.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.zly.www.bzmh.R;
import com.zly.www.bzmh.base.BaseActivity;
import com.zly.www.bzmh.fragment.DrawerFragment;
import com.zly.www.bzmh.fragment.HomeFragment;
import com.zly.www.bzmh.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbar.setTitle("暴走日报");
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

        replaceFragment(R.id.fl_container, new HomeFragment());
        replaceFragment(R.id.fl_drawer, new DrawerFragment());
    }

    public void replaceFragment(int id,Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }


    private long clickTime = 0;

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i("test", "onPrepareOptionsMenu");

        return super.onPrepareOptionsMenu(menu);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("test", "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_msg://消息
//                invalidateOptionsMenu();
                break;
            case R.id.item_refresh://刷新
                break;
            case R.id.item_setting://设置
                break;
        }
        return true;
    }

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
