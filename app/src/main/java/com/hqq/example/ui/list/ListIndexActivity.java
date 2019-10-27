package com.hqq.example.ui.list;

import com.hqq.core.ui.BaseListActivity;
import com.hqq.example.adapter.MainAdapter;
import com.hqq.example.bean.MainBean;
import com.hqq.example.ui.IFragmentActivity;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.coreapp.ui.activity.list
 * @FileName :   ListIndexActivity
 * @Date : 2019/5/25 0025  下午 5:41
 * @Email : qiqiang213@gmail.com
 * @Descrive :
 */
public class ListIndexActivity extends BaseListActivity<MainAdapter> {
    @Override
    public MainAdapter initAdapter() {
        return new MainAdapter();
    }

    @Override
    public void initData() {
        mAdapter.addData(new MainBean("加载数据", LoadMoreActivity.class));
        mAdapter.addData(new MainBean("fragment 加载", IFragmentActivity.class));
        mAdapter.addData(new MainBean("ListActivity 加载", ListActivity.class));

    }

}