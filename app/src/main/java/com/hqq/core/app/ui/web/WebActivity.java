package com.hqq.core.app.ui.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hqq.core.app.R;
import com.hqq.core.ui.BaseFrameLayoutActivity;
import com.hqq.core.ui.web.BaseWebFragment;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.app.ui.web
 * @FileName :   WebActivity
 * @Date : 2019/8/5 0005  下午 7:52
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 */

public class WebActivity extends BaseFrameLayoutActivity {


    @Override
    public int setViewId() {
        return R.layout.activity_web;
    }


    @Override
    public void initDefConfig() {
        super.initDefConfig();
        mRootViewBuild.setShowToolBar(false);
        mRootViewBuild.setShowStatus(false);
    }

    @Override
    public void initView() {
        BaseWebFragment mBaseFragment = BaseWebFragment.instantiate(this, "网页", "https://www.baidu.com/");
        addOrShowFragment(mBaseFragment, R.id.fl_layout);
    }
}