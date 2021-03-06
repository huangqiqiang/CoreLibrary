package com.hqq.example.ui.exception

import android.view.View
import com.hqq.core.ui.base.BaseActivity
import com.hqq.core.utils.log.LogUtils.e
import com.hqq.example.R

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.coreapp.ui.activity
 * @FileName :   ThrowActivity
 * @Date : 2019/5/22 0022
 * @Email :  qiqiang213@gmail.com
 * @Descrive :异常
 */
class ThrowActivity : BaseActivity() {

    override val layoutViewId: Int
        get() = R.layout.activity_throw
    override fun initView() {
        findViewById<View>(R.id.button11).setOnClickListener { view: View -> onViewClicked(view) }
        findViewById<View>(R.id.button12).setOnClickListener { view: View -> onViewClicked(view) }
    }

    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.button11 -> e(Exception("一个异常 "))
            R.id.button12 -> e(RuntimeException("一个运行异常 "))
            else -> {
            }
        }
    }
}