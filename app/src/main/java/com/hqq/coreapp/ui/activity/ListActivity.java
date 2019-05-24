package com.hqq.coreapp.ui.activity;

import android.os.Handler;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hqq.coreapp.adapter.MainAdapter;
import com.hqq.coreapp.bean.MainBean;
import com.hqq.core.ui.BaseListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.iblibrary.ui.activity
 * @FileName :   ListActivity
 * @Date : 2018/12/14 0014
 * @Descrive : TODO
 * @Email :  qiqiang213@gmail.com
 */
public class ListActivity extends BaseListActivity<MainAdapter> {
    @Override
    public MainAdapter initAdapter() {
        return new MainAdapter();
    }

    @Override
    public void initData() {
        getData();
    }

    private void getData() {
        mLoadingView.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<MainBean> list = new ArrayList<>();
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                list.add(new MainBean("ItoolBar 控制 ", ToolBarActivity.class));
                list.add(new MainBean("fragment 加载", IFragmentActivity.class));
                mLoadingView.dismiss();
                mBaseListModel.fillingData(list);

            }
        }, 3 * 1000);

    }
}
