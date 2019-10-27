package com.hqq.example.ui.launch.mode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hqq.core.ui.BaseActivity;
import com.hqq.example.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.app.ui.launch.mode
 * @FileName :   LaunchModeAActivity
 * @Date : 2019/10/25 0025  上午 9:43
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 */
public class LaunchModeAActivity extends LaunchActivity {

    public static void open(Activity context) {
        Intent starter = new Intent(context, LaunchModeAActivity.class);
        context.startActivityForResult(starter, -1);
    }


}
