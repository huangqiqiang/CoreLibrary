package com.hqq.example.ui.customize

import android.app.Activity
import android.content.Intent
import com.hqq.core.ui.base.BaseActivity

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.example.ui.customize
 * @Date : 上午 11:15
 * @Email : qiqiang213@gmail.com
 * @Descrive :
 */
class DiskViewActivity : BaseActivity() {
    companion object {
        fun open(context: Activity) {
            context.startActivityForResult(Intent(context, DiskViewActivity::class.java), -1)
        }
    }

    override val layoutViewId: Int = com.hqq.example.R.layout.activity_disk_view

    override fun initView() {}
}