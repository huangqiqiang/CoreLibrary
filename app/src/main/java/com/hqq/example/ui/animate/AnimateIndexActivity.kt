package com.hqq.example.ui.animate

import android.content.Context
import android.content.Intent
import com.hqq.core.ui.list.BaseListActivity
import com.hqq.example.adapter.MainAdapter
import com.hqq.example.bean.MainBean

class AnimateIndexActivity(override val adapter: MainAdapter=MainAdapter()) : BaseListActivity() {
    override fun initData() {
        adapter!!.addData(MainBean("隐藏动画", ViewAnimateActivity::class.java))
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {}

    companion object {
        fun open(context: Context) {
            val starter = Intent(context, AnimateIndexActivity::class.java)
            context.startActivity(starter)
        }
    }
}