package com.zly.www.bzmh.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.zly.www.bzmh.R;
import com.zly.www.bzmh.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zly on 2016/3/26.
 */
public class SplashActivity extends BaseActivity {
    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        startAnimator();
    }

    private void startAnimator() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv,"scaleX",1f,1.2f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv,"scaleY",1f,1.2f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator1,animator2);
        animatorSet.setDuration(1500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        });
        animatorSet.start();
    }


}
