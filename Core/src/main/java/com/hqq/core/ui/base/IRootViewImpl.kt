package com.hqq.core.ui.base

import android.app.Activity
import android.content.pm.ActivityInfo
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.hqq.core.R
import com.hqq.core.annotation.LayoutModel
import com.hqq.core.annotation.ToolBarMode
import com.hqq.core.toolbar.BaseDefToolBarImpl
import com.hqq.core.toolbar.BaseToolBar
import com.hqq.core.ui.builder.ICreateRootView
import com.hqq.core.ui.builder.IRootView
import com.hqq.core.ui.model.CreateRootViewModel
import com.hqq.core.utils.log.LogUtils

/**
 * @Author : huangqiqiang
 * @Package : com.core.library.ui
 * @FileName :   RootViewBuilder
 * @Date : 2018/12/4 0004  下午 7:03
 * @Descrive :
 * @Email :  qiqiang213@gmail.com
 * 1. 　动态添加 生成根布局  支持LineLayout 与FarmLayout
 * 2. 　根据条件　判断添加状态栏标题栏以及设置状态栏模式
 */
class IRootViewImpl<T : Any>(context: T, isShowStatus: Boolean, isShowToolBar: Boolean) : IRootView {
    /**
     * 当前activity
     */
    private var mActivity: Activity? = null

    /**
     * 获取跟布局
     *
     * @return
     */
    /**
     * 根布局
     */
    var rootView: View? = null
        private set

    /**
     * 是否强制竖屏
     *
     * @return
     */
    /**
     * 是否强制竖屏
     */
    var isAlwaysPortrait = true
        private set

    /**
     * 布局构建器
     */
    var mCreateRootViewModel: CreateRootViewModel

    constructor(activity: T) : this(activity, false, false) {}

    override fun buildContentView(iActivityBuilder: ICreateRootView): View? {
        rootView = mCreateRootViewModel.createRootView(iActivityBuilder)
        return rootView
    }

    override fun initActivity(fullScreen: Boolean) {
        // 全屏的需求只有在activity上才需要的
        if (fullScreen) {
            //隐藏状态 上的字体和颜色
            mActivity!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            mActivity!!.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                    , WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        //强制竖屏
        if (isAlwaysPortrait) {
            mActivity!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }
    /*********************************Builder 方法 */
    /**
     * 获取默认状态栏
     *
     * @return
     */
    fun <T> getDefToolBar(): BaseDefToolBarImpl? {
        return if (mCreateRootViewModel.getIToolBar<BaseToolBar?>() != null && mCreateRootViewModel.getIToolBar<BaseToolBar>() is BaseDefToolBarImpl) {
            mCreateRootViewModel.getIToolBar<BaseToolBar>() as BaseDefToolBarImpl
        } else {
            // 自定义的异常 目前先抛出 类型不正确
            LogUtils.e(Exception("RootViewBuilder no fount BaseDefToolBarImpl "))
            null
        }
    }

    /**
     * 设置根部的样式  目前只支持两种  布局
     *
     * @param layoutMode
     */
    fun setLayoutMode(@LayoutModel layoutMode: Int): IRootViewImpl<T> {
        mCreateRootViewModel.setLayoutMode(layoutMode)
        return this
    }

    /**
     * toolBar 的类名
     *
     * @param clss
     */
    fun setIToolBarClass(clss: Class<out BaseToolBar?>): IRootViewImpl<T> {
        mCreateRootViewModel.setIToolBarClass(clss)
        return this
    }

    /**
     * 是否显示  状态栏  与标题栏
     *
     * @param showStatus  状态栏
     * @param showToolBar 标题栏
     */
    fun setToolbarVisibility(showStatus: Boolean, showToolBar: Boolean): IRootViewImpl<T> {
        mCreateRootViewModel.setToolbarVisibility(showStatus, showToolBar)
        return this
    }

    /**
     * 是否显示标题栏
     *
     * @param showStatus
     */
    fun setShowStatusBar(showStatus: Boolean): IRootViewImpl<T> {
        mCreateRootViewModel.setShowStatusBar(showStatus)
        return this
    }

    /**
     * 是否显示标题栏
     *
     * @param showToolBar
     */
    fun setShowToolBar(showToolBar: Boolean): IRootViewImpl<T> {
        mCreateRootViewModel.setShowToolBar(showToolBar)
        return this
    }

    /**
     * 设置状态栏模式
     *
     * @param statusBarMode
     * @return
     */
    fun setStatusBarMode(@ToolBarMode statusBarMode: Int): IRootViewImpl<T> {
        mCreateRootViewModel.statusBarMode = statusBarMode
        return this
    }

    /**
     * 状态栏颜色
     *
     * @param statusColor
     */
    fun setStatusColor(@ColorRes statusColor: Int) {
        mCreateRootViewModel.setStatusColor(statusColor)
    }

    /**
     * 获取状态栏模式
     *
     * @return
     */
    val statusBarMode: Int
        get() = mCreateRootViewModel.statusBarMode

    /**
     * 设置是否竖屏
     *
     * @param alwaysPortrait
     * @return
     */
    fun setAlwaysPortrait(alwaysPortrait: Boolean): IRootViewImpl<T> {
        isAlwaysPortrait = alwaysPortrait
        return this
    }

    init {
        mCreateRootViewModel = CreateRootViewModel(isShowStatus, isShowToolBar)
        if (context is Activity) {
            mActivity = context
            // 只有在Activity的情况下才会去设置状态栏的颜色  其他的情况默认采用 activity的颜色
            mCreateRootViewModel.setImmersiveStatusBar(true)
        } else if (context is DialogFragment) {
            mActivity = (context as DialogFragment).activity
            mCreateRootViewModel.setBgColor(R.color.transparent)
        } else if (context is Fragment) {
            mActivity = (context as Fragment).activity
        } else {
            LogUtils.e(Exception("不支持的类" + context.javaClass.getName()))
        }
        mCreateRootViewModel.setActivity(mActivity)
    }
}