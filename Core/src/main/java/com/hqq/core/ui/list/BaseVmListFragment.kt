package com.hqq.core.ui.list

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.module.LoadMoreModule
import com.hqq.core.R
import com.hqq.core.ui.base.BaseVmFragment
import com.hqq.core.ui.list.BaseListModel.IBaseListModelView

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.ui.vm
 * @FileName :   BaseListFragment
 * @Date : 2020/7/29 0029  下午 2:29
 * @Email : qiqiang213@gmail.com
 * @Descrive :
 */
abstract class BaseVmListFragment<K : BaseListViewModel,T : ViewDataBinding>
    : BaseVmFragment<K,T >(), IBaseListModelView {

    override var listView: RecyclerView? = null
    override val layoutId: Int = R.layout.activity_recycle_view
    override val pageCount: Int get() = viewMode.pageCount
    override val pageSize: Int get() = viewMode.pageSize
    override var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
    override lateinit var listModel: BaseListModel


    override fun initViews() {
        listModel = BaseListModel(this, rootViewImpl)
        viewMode!!.data.observe(this, Observer<List<*>> { arrayList ->
            listModel!!.fillingData(arrayList as List<Nothing>)
        })
        initData()
    }


    override fun addPageCount() {
        viewMode!!.setPageCount(viewMode!!.pageCount + 1)
    }

    override fun onRefreshBegin() {
        if (adapter is LoadMoreModule) {
            viewMode!!.setPageCount(1)
            adapter.loadMoreModule.loadMoreComplete()
            viewMode!!.onLoadMore()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onLoadMore() {
        viewMode!!.onLoadMore()

    }

}


