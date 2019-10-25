package com.hqq.core.app.ui.launch.mode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hqq.core.app.R;
import com.hqq.core.ui.BaseActivity;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.app.ui.launch.mode
 * @FileName :   LaunchModeCActivity
 * @Date : 2019/10/25 0025  上午 9:44
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 */
public class LaunchModeCActivity extends BaseActivity {
    public static void open(Activity context) {
        Intent starter = new Intent(context, LaunchModeCActivity.class);
        context.startActivityForResult(starter, -1);
    }


    @Override
    public int setViewId() {
        return R.layout.activity_launch_mode_a;
    }

    @Override
    public void initView() {

    }
}
