package com.hqq.core.listenner

import android.graphics.Bitmap

/**
 * @Author : huangqiqiang
 * @Package : com.qi.core.listenner
 * @FileName :   WebLoadListener
 * @Date : 2019/3/22 0022  上午 11:47
 * @Email : qiqiang213@gmail.com
 * @Descrive :
 */
interface WebLoadListener {
    /**
     * 开始加载网页
     *
     * @param url     String
     * @param favicon
     */
    fun onPageStarted(url: String?, favicon: Bitmap?)

    /**
     * 结束加载网页
     * @param url String
     */
    fun onPageFinished(url: String?)
}