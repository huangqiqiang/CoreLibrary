package com.hqq.core.glide

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hqq.core.CoreBuildConfig
import com.hqq.core.R
import com.hqq.core.utils.ResourcesUtils

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.blibrary.glide
 * @FileName :   ImageLoadUtils
 * @Date : 2018/2/9  9:23
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 * 目的 只是为了更方便的替换Glide以及维护图片的加载
 * 参考 http://blog.csdn.net/hexingen/article/details/72578066
 * 参考 http://blog.csdn.net/wyb112233/article/details/52337392
 */
object ImageLoadUtils {//缓存SOURC和RESULT
    //不做内存缓存
    /**
     * 默认配置
     *
     * @return
     */
    val requestOptions: RequestOptions
        get() = RequestOptions()
                .format(DecodeFormat.PREFER_RGB_565) //缓存SOURC和RESULT
                .diskCacheStrategy(DiskCacheStrategy.ALL) //不做内存缓存
                .skipMemoryCache(false)
                .dontAnimate()
                .placeholder(CoreBuildConfig.instance!!.defImg)//缓存SOURC和RESULT
    //不做内存缓存

    /**
     * 默认配置
     *
     * @return
     */
    val roundRequestOptions: RequestOptions
        get() = RequestOptions()
                .format(DecodeFormat.PREFER_RGB_565) //缓存SOURC和RESULT
                .diskCacheStrategy(DiskCacheStrategy.ALL) //不做内存缓存
                .skipMemoryCache(false)
                .dontAnimate()
                .placeholder(CoreBuildConfig.instance!!.defImg)

    fun getDefRoundRequestOptions(context: Context?): RequestOptions {
        return getRoundRequestOptions(ResourcesUtils.getDimen(R.dimen.x10).toInt())
    }

    /**
     * 圆角的 图片
     *
     * @param px
     * @return
     */
    fun getRoundRequestOptions(px: Int): RequestOptions {
        return RequestOptions()
                .format(DecodeFormat.PREFER_RGB_565) //缓存SOURC和RESULT
                .diskCacheStrategy(DiskCacheStrategy.ALL) //不做内存缓存
                .skipMemoryCache(false)
                .dontAnimate()
                .placeholder(CoreBuildConfig.instance!!.defImg)
                .transform(GlideRoundTransform(px))
    }

    /**
     * 验证  view   是否 合法
     * 判断  界面是否销毁
     *
     * @param view
     * @return
     */
    fun checkFinish(view: View?): Boolean {
        if (view == null || view.context == null) {
            return true
        }
        if (view.context is Activity) {
            val activity = view.context as Activity
            if (activity.isFinishing) {
                return true
            }
        }
        return false
    }

    /**
     * 加载图片
     *
     * @param url       String 地址
     * @param imageView
     */
    fun with(url: String?, imageView: ImageView?) {
        if (checkFinish(imageView)) {
            return
        }
        GlideApp.with(imageView!!)
                .load(url)
                .apply(requestOptions)
                .into(imageView)
    }

    /**
     * 加载本地图片
     *
     * @param url
     * @param imageView
     */
    fun with(@RawRes @DrawableRes url: Int, imageView: ImageView?) {
        if (checkFinish(imageView)) {
            return
        }
        GlideApp.with(imageView!!)
                .load(url)
                .apply(requestOptions
                ).into(imageView)
    }

    /**
     * 加载图片  指定宽度
     *
     * @param url
     * @param imageView
     * @param width     宽
     * @param height    高
     */
    fun with(url: String?, imageView: ImageView?, width: Int, height: Int) {
        if (checkFinish(imageView)) {
            return
        }
        GlideApp.with(imageView!!)
                .load(url)
                .apply(
                        requestOptions
                                .override(width, height)
                ).into(imageView)
    }

    /**
     * 圆角
     *
     * @param url
     * @param imageView
     */
    fun withFillet(url: String?, imageView: ImageView) {
        if (checkFinish(imageView)) {
            return
        }
        GlideApp.with(imageView)
                .load(url)
                .apply(getDefRoundRequestOptions(imageView.context))
                .into(imageView)
    }

    /**
     * @param url
     * @param imageView
     * @param radius    圆角  单位 px
     */
    fun withFillet2PX(url: String?, imageView: ImageView?, radius: Int) {
        if (checkFinish(imageView)) {
            return
        }
        GlideApp.with(imageView!!)
                .load(url)
                .apply(
                        roundRequestOptions.transforms(CenterCrop(), RoundedCorners(radius))
                )
                .into(imageView)
    }

    /**
     * 加载圆形图
     *
     * @param url
     * @param imageView
     */
    fun transformHead(url: String?, imageView: ImageView?) {
        if (checkFinish(imageView)) {
            return
        }
        GlideApp.with(imageView!!).load(url).apply(
                RequestOptions.circleCropTransform()
                        .placeholder(R.mipmap.ic_def_head)
        ).into(imageView)
    }

    /**
     * 圆角头像
     *
     * @param url
     * @param imageView
     */
    fun transformCircularHead(url: String?, imageView: ImageView?) {
        if (checkFinish(imageView)) {
            return
        }
        GlideApp.with(imageView!!)
                .load(url)
                .thumbnail()
                .apply(RequestOptions.circleCropTransform() //不做内存缓存
                        .skipMemoryCache(true)
                        .dontAnimate()
                        .placeholder(R.mipmap.ic_def_head_circular)
                )
                .into(imageView)
    }
}