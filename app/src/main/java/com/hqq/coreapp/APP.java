package com.hqq.coreapp;

import android.app.Application;

import com.hqq.core.CoreBuildConfig;
import com.squareup.leakcanary.LeakCanary;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.iblibrary
 * @FileName :   APP
 * @Date : 2018/11/23 0023  下午 2:21
 * @Descrive :
 * @Email :
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //配置 默认加载的 toolBar
        CoreBuildConfig.getInstance().init(this, true);
        //.setDefItoobar(BaseDefToolBarImpl.class);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);


    }
}
