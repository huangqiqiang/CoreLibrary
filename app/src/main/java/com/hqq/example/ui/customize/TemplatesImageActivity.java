package com.hqq.example.ui.customize;


import android.app.Activity;
import android.content.Intent;

import com.hqq.core.ui.base.BaseActivity;
import com.hqq.example.R;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.example.ui.customize
 * @FileName :   TemplatesImageActivity
 * @Date : 2020/1/10 0010  下午 1:41
 * @Email :  qiqiang213@gmail.com
 * @Descrive : 限定区域内图片拖动
 */
public class TemplatesImageActivity extends BaseActivity {

    public static void open(Activity context) {
        Intent starter = new Intent(context, TemplatesImageActivity.class);
        context.startActivityForResult(starter, -1);
    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_templates_image;
    }

    @Override
    public void initView() {

    }
}
