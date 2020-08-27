package com.hqq.core.ui.binding

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.hqq.core.BaseCommonsKey
import com.hqq.core.R
import com.hqq.core.ui.base.BaseListModelView

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.ui.binding
 * @FileName :   BaseBindingListActivity
 * @Date  : 2020/8/27 0027  上午 10:48
 * @Email : qiqiang213@gmail.com
 * @Descrive :
 */
abstract class BaseBindingListActivity<T : ViewDataBinding, AD : BaseQuickAdapter<*, *>>
    : BaseBindingActivity<T>(), BaseListModelView.IBaseListModelView<AD> {

    /**
     * List列表模型
     */
    var mBaseListModel: BaseListModelView? = null

    override val layoutId: Int
        get() = R.layout.activity_recycle_view

    /**
     *  分页下标
     */
    override var pageCount = 1
    override var pageSize = BaseCommonsKey.PAGE_SIZE

    override var listView: RecyclerView? = null
    override val rcLayoutManager: RecyclerView.LayoutManager
        get() = LinearLayoutManager(this)


    /**
     * 初始化  基础数据
     */
    @CallSuper
    override fun initView() {
        mBaseListModel = BaseListModelView(this, iCreateRootView)
        initData()
    }

    /**
     *  分页增加
     */
    override fun addPageCount() {
        pageCount += 1
    }

    /**
     *  下拉刷新 开始从第一页 获取数据
     */
    override fun onRefreshBegin() {
        pageCount = 1
        baseAdapter?.loadMoreModule?.loadMoreComplete()
        onLoadMore()
    }

    /**
     *  销毁
     */
    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        mBaseListModel = null
    }

    /**
     *  加载更多数据
     */
    override fun onLoadMore() {
    }


}