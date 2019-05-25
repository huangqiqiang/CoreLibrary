package com.hqq.coreapp.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hqq.core.ui.BaseListActivity;
import com.hqq.core.utils.ToastUtils;
import com.hqq.coreapp.adapter.MainAdapter;
import com.hqq.coreapp.bean.MainBean;
import com.hqq.coreapp.ui.activity.bannner.BannerActivity;
import com.hqq.coreapp.ui.activity.customize.CustomizeIndexActivity;
import com.hqq.coreapp.ui.activity.dialog.BottomSheetActivity;
import com.hqq.coreapp.ui.activity.DefImgActivity;
import com.hqq.coreapp.ui.activity.dialog.DialogIndexActivity;
import com.hqq.coreapp.ui.activity.list.ListIndexActivity;
import com.hqq.coreapp.ui.activity.screen.DimenActivity;
import com.hqq.coreapp.ui.activity.IFragmentActivity;
import com.hqq.coreapp.ui.activity.list.ListActivity;
import com.hqq.coreapp.ui.activity.list.LoadMoreActivity;
import com.hqq.coreapp.ui.activity.PermissionActivity;
import com.hqq.coreapp.ui.activity.dialog.TestDialogActivity;
import com.hqq.coreapp.ui.activity.screen.TextViewSizeActivity;
import com.hqq.coreapp.ui.activity.ThrowActivity;
import com.hqq.coreapp.ui.activity.bar.ToolBarActivity;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.iblibrary
 * @FileName :   MainActivity
 * @Date : 2018/11/22 0022
 * @Descrive : TODO
 * @Email :  qiqiang213@gmail.com
 */
public class MainActivity extends BaseListActivity<MainAdapter> {


    @Override
    public MainAdapter initAdapter() {
        return new MainAdapter();
    }

    @Override
    public void initData() {
        mAdapter.addData(new MainBean("标题/状态栏设置", ToolBarActivity.class));
        mAdapter.addData(new MainBean("默认图显示", DefImgActivity.class));
        mAdapter.addData(new MainBean("轮播图", BannerActivity.class));
        mAdapter.addData(new MainBean("权限测试", PermissionActivity.class));
        mAdapter.addData(new MainBean("文字适配测试", TextViewSizeActivity.class));
        mAdapter.addData(new MainBean("1像素大小测试", DimenActivity.class));
        mAdapter.addData(new MainBean("Throw异常测试", ThrowActivity.class));
        mAdapter.addData(new MainBean("列表系列", ListIndexActivity.class));
        mAdapter.addData(new MainBean("Dialog系列", DialogIndexActivity.class));
        mAdapter.addData(new MainBean("自定义系列", CustomizeIndexActivity.class));
    }


    private long exitTime = 0;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                ToastUtils.showToast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                Intent mHomeIntent = new Intent(Intent.ACTION_MAIN);
                mHomeIntent.addCategory(Intent.CATEGORY_HOME);
                mHomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(mHomeIntent);
                // 退出程序
                System.exit(0);
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
