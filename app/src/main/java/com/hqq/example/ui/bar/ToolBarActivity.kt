package com.hqq.example.ui.bar

import android.app.Activity
import android.content.Intent
import android.view.View
import com.hqq.core.toolbar.DefToolBar
import com.hqq.core.ui.base.BaseActivity
import com.hqq.core.utils.ToastUtils.showToast
import com.hqq.core.utils.statusbar.StatusBarManager.setStatusBarModel
import com.hqq.example.R

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.iblibrary.ui.activity
 * @FileName :   ToolBarActivity
 * @Date : 2018/11/22 0022
 * @Descrive : TODO
 * @Email :  qiqiang213@gmail.com
 */
class ToolBarActivity : BaseActivity() {

    override val layoutViewId: Int
        get() = R.layout.activity_tool_bar

    override fun initView() {


        iToolBar?.let {
            (iToolBar as DefToolBar).addRightTextView("分享", View.OnClickListener { showToast(activity, "点击分享") })
            (iToolBar as DefToolBar).addRightTextView("分享", R.color.color_333, View.OnClickListener { showToast(activity, "点击分享") })
            (iToolBar as DefToolBar).addRightImageView(R.mipmap.ic_more, View.OnClickListener { showToast(activity, "点击more") })
        }

        findViewById<View>(R.id.button).setOnClickListener(this)
        findViewById<View>(R.id.button2).setOnClickListener(this)
        findViewById<View>(R.id.button3).setOnClickListener(this)
        findViewById<View>(R.id.button4).setOnClickListener(this)
        findViewById<View>(R.id.button5).setOnClickListener(this)
        findViewById<View>(R.id.button6).setOnClickListener(this)
        findViewById<View>(R.id.button7).setOnClickListener(this)
        findViewById<View>(R.id.button8).setOnClickListener(this)
        findViewById<View>(R.id.button12).setOnClickListener(this)
        findViewById<View>(R.id.button13).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.tv_bar_right -> {
            }
            R.id.button5 -> iToolBar?.setStatusColor(R.color.color_77400a)
            R.id.button4 -> iToolBar?.toolBarBg?.setImageResource(R.color.white)
            R.id.button7 -> iToolBar?.toolBarBg?.setImageResource(R.color.color_000)
            R.id.button3 -> iToolBar?.toolBarBg?.setImageResource(R.color.color_77400a)
            R.id.button -> setStatusBarModel(activity.window, true)
            R.id.button2 -> setStatusBarModel(activity.window, false)
            R.id.button6 -> iToolBar?.setToolbarTitle("new标题")
            R.id.button8 -> iToolBar?.setToolBarColor(R.color.color_main)
            R.id.button12 -> SettingToolBarActivity.open(this)
            R.id.button13 -> SearchBarActivity.open(this)
            else -> {
            }
        }
    }

    companion object {
        fun open(context: Activity) {
            val starter = Intent(context, ToolBarActivity::class.java)
            context.startActivityForResult(starter, -1)
        }
    }
}