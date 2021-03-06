package com.hqq.example.ui.web

import android.app.Activity
import android.content.Intent
import com.hqq.core.ui.base.BaseFrameLayoutActivity
import com.hqq.core.ui.web.BaseWebFragment
import com.hqq.example.R

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.app.ui.web
 * @FileName :   WebActivity
 * @Date : 2019/8/5 0005  下午 7:52
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 */
class WebActivity : BaseFrameLayoutActivity() {


    override val layoutViewId: Int
        get() = R.layout.activity_web

    override fun initConfig() {
        super.initConfig()
        rootViewImpl.iToolBarBuilder.showStatusBar = false
        rootViewImpl.iToolBarBuilder.showToolBar = false
    }

    override fun initView() {
        var url = intent.extras?.getString(URL, "https://www.baidu.com/")
        var title = intent.extras?.getString(TITLE, "网页")
        url = if (url == null)"https://www.baidu.com/" else url
        title = if (title == null)"网页" else title
        val mBaseFragment = BaseWebFragment.instantiate(this, title, url)
        addOrShowFragment(mBaseFragment, R.id.fl_layout)
    }

    override fun onBackPressed() {
        if (currentFragment != null) {
            if (!(currentFragment as BaseWebFragment).onBackPressed()) {
                super.onBackPressed()
            }
        }
    }

    companion object {
        const val URL = "URL"
        const val TITLE = "TITLE"
        fun open(context: Activity, url: String?, title: String?) {
            val starter = Intent(context, WebActivity::class.java)
            starter.putExtra(URL, url)
            starter.putExtra(TITLE, title)
            context.startActivityForResult(starter, -1)
        }
    }
}