package com.hqq.core.toolbar

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.ColorRes
import com.hqq.core.R
import java.lang.ref.WeakReference

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.toolbar
 * @FileName :   IToolBar
 * @Date : 2019/5/8 0008  下午 3:43
 * @Email : qiqiang213@gmail.com
 * @Descrive :
 *
 *
 * StatusBar  状态栏
 * TitleBar  标题栏
 * ToolBar  标题栏+状态栏
 *
 *
 * 由于这边是View 存在两种情况
 * - 在View 还未初始化完成 未添加到Activity中
 * - 在View 初始化完成 已经添加到 Activity后
 */
interface IToolBar {

    /**
     * 构建后生成的View
     *
     * @return view
     */
    val rootView: View?

    /**
     * 背景颜色
     */
    var toolBarBg: ImageView?

    /**
     * 构建  标题栏
     *
     * @param activity activity
     * @return  this
     */
    fun createToolBar(activity: Activity?): IToolBar

    /**
     * 构建toolBar
     *
     * @param activity  activity
     * @param viewGroup viewGroup
     * @return rootView
     */
    fun iniToolBar(activity: Activity, viewGroup: ViewGroup?): View

    /**
     * bar 的颜色
     *
     * @param colorId 颜色id
     */
    fun setToolBarColor(colorId: Int)

    /**
     * 状态栏
     *
     * @param isShowStatusBar 是否显示
     * @return this
     */
    fun setShowStatusBar(isShowStatusBar: Boolean): IToolBar

    /**
     * 是否显示 toolBar
     *
     * @param isShowToolBar 是否显示
     * @return this
     */
    fun setShowBar(isShowToolBar: Boolean): IToolBar

    /**
     * 默认的 状态栏颜色
     *
     * @param statusBarColor 颜色值
     * @return this
     */
    fun setStatusColor(@ColorRes statusBarColor: Int): IToolBar


    /**
     *  设置 toolBar 中的 标题
     */
    fun setToolbarTitle(title: CharSequence?)

    /**
     *  中间的一条线
     */
    fun showLine(boolean: Boolean): IToolBar


    open class Builder {
        var activity: WeakReference<Activity>? = null

        /**
         * 是否显示 状态栏 背景
         */
        var showStatusBar = true

        /**
         * 是否显示 ToolBar
         */
        var showToolBar = true

        var showLine = true

        /**
         * 默认白色
         */
        @ColorRes
        var statusBarColor = R.color.white

        /**
         * @param clss 类型
         * @return
         */
        fun create(iCreateToolbar: IToolBar?): IToolBar? {
            iCreateToolbar?.run {
                setShowStatusBar(showStatusBar)
                setShowBar(showToolBar)
                showLine(showLine)
                setStatusColor(statusBarColor)
                createToolBar(activity?.get())
            }
            return iCreateToolbar
        }
    }
}