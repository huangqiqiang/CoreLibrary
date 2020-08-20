package com.hqq.example.ui.tab.layout

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.hqq.core.adapter.BaseFragmentAdapter
import com.hqq.core.ui.base.BaseActivity
import com.hqq.example.R

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core_app.ui.activity.tab_layout
 * @FileName :   TabLayoutActivity
 * @Date : 2019/6/6 0006  下午 6:00
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 */
class TabLayoutActivity : BaseActivity() {

    companion object {
        fun open(context: Activity) {
            context.startActivityForResult(Intent(context, TabLayoutActivity::class.java), -1)
        }
    }

    var mTbTablayout1: TabLayout? = null
    var mVpPage: ViewPager2? = null
    var mTbTablayout2: TabLayout? = null
    var mTbTablayout3: TabLayout? = null
    var mTbTablayout4: TabLayout? = null

    override val layoutViewId: Int
        get() = R.layout.activity_tab_layout

    override fun initDefConfig() {
        super.initDefConfig()
        rootViewBuild?.setStatusColor(R.color.color_main)
    }

    override fun initView() {
        mTbTablayout4 = findViewById(R.id.tb_tablayout4)
        mTbTablayout3 = findViewById(R.id.tb_tablayout3)
        mTbTablayout2 = findViewById(R.id.tb_tablayout2)
        mVpPage = findViewById(R.id.vp_page)
        mTbTablayout1 = findViewById(R.id.tb_tablayout1)


        val adapter = ViewPageAdapter(this)
        mVpPage!!.setAdapter(adapter)
        adapter.setupWithViewPager(mTbTablayout1!!, mVpPage!!)
        adapter.setupWithViewPager(mTbTablayout2!!, mVpPage!!)
        adapter.setupWithViewPager(mTbTablayout3!!, mVpPage!!)
        adapter.setupWithViewPager(mTbTablayout4!!, mVpPage!!)
    }

    internal inner class ViewPageAdapter(fragmentActivity: FragmentActivity) : BaseFragmentAdapter(fragmentActivity) {
        override fun newFragment(position: Int): Fragment {
            return TabFragment()
        }
        init {
            stringSparseArray.append(0, "咖啡")
            stringSparseArray.append(1, "奶茶")
            stringSparseArray.append(2, "菊花茶")
            stringSparseArray.append(3, "霸王杯")
            stringSparseArray.append(4, "冬瓜茶")
        }
    }
}