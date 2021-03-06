package com.hqq.example.ui.customize;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

import com.hqq.core.ui.base.BaseActivity;
import com.hqq.example.R;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.coreapp.ui.activity.animation
 * @FileName :   BezierActivity
 * @Date : 2019/5/24 0024
 * @Email :  qiqiang213@gmail.com
 * @Descrive : TODO
 */
public class BezierActivity extends BaseActivity {

    public static void open(Activity context) {
        Intent starter = new Intent(context, BezierActivity.class);
        context.startActivityForResult(starter, -1);
    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_bezier;
    }

    @Override
    public void initView() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);

    }
}
