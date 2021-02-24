/*
 * Create on 2016-12-14 下午3:54
 * FileName: OkHttpImpl.java
 * Author: huang qiqiang
 * Contact: http://www.huangqiqiang.cn
 * Email 593979591@QQ.com
 *
 */
package com.hqq.core.net.ok

import android.os.Handler
import android.os.Looper
import com.hqq.core.net.ok.HttpCompat.ParamsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

/**
 * @version V1.0 <描述当前版本功能>
 * @Author : huangqiqiang
 * @Package : com.hqq.core.net.ok
 * @FileName :   OkHttpImpl
 * @Date : 2016/12/14  下午15:54
 * @Email : qiqiang213@gmail.com
 * @Descrive :
</描述当前版本功能> */
class OkHttpImpl : HttpCompat {
    var mOkHttpClient: OkHttpClient? = null
    var mHandler: Handler? = null
    override fun create(): HttpCompat {
        mOkHttpClient = OkHttpClient.Builder() //设置读取超时时间
                .readTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS) //设置写的超时时
                .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .connectTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .build()
        mHandler = Handler(Looper.getMainLooper())
        return this
    }

    /**
     * get 请求
     *
     * @param url
     * @param params
     * @param callback
     */
    override fun get(url: String, params: ParamsCompat, callback: OkNetCallback) {
        doGet(mHandler, url, params, callback)
    }

    /**
     * 同步的get  请求
     *
     * @param url
     * @param params
     * @param callback
     * @return
     */
    override fun getExecute(url: String, params: ParamsCompat, callback: OkNetCallback): Call {
        val request: Request.Builder = getBuilder(url, params)
        val call = mOkHttpClient!!.newCall(request.build())
        try {
            val response = call.execute()
            postHandler(null, callback, response, params)
        } catch (e: IOException) {
            e.printStackTrace()
            postHandler(null, callback, null, null)
        }
        return call
    }

    private fun getBuilder(url: String, params: ParamsCompat?): Request.Builder {
        val realUrl: String
        realUrl = if (params != null) {
            url + '?' + params.paramGet()
        } else {
            url
        }
        return Request.Builder().url(realUrl).get()
    }

    /**
     * 执行get 请求
     *
     * @param handler
     * @param url
     * @param params
     * @param callback
     * @return
     */
    private fun doGet(handler: Handler?, url: String, params: ParamsCompat, callback: OkNetCallback): Call {
        val request: Request.Builder = getBuilder(url, params)
        val call = mOkHttpClient!!.newCall(request.build())
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                postHandler(handler, callback, null, null)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                postHandler(handler, callback, response, params)
            }
        })
        return call
    }

    /**
     * post 请求
     *
     * @param url
     * @param params
     * @param callback
     * @return
     */
    override fun post(url: String, params: ParamsCompat, callback: OkNetCallback): Call {
        return doPost(url, params, callback, mHandler)
    }

    /**
     * 执行post 请求
     *
     * @param url
     * @param params
     * @param callback
     * @param o
     * @return
     */
    private fun doPost(url: String, params: ParamsCompat, callback: OkNetCallback, o: Handler?): Call {
        val body = params.paramForm<RequestBody>()
        val request: Request.Builder = Request.Builder().url(url).post(body)
        return doRequest(o, request, callback, params)
    }

    /**
     * 同步请求
     *
     * @param url
     * @param params
     * @param callback
     * @return
     */
    override fun postExecute(url: String, params: ParamsCompat, callback: OkNetCallback): Call {
        val body = params.paramForm<RequestBody>()
        val request: Request.Builder = Request.Builder().url(url).post(body)
        val call = mOkHttpClient!!.newCall(request.build())
        try {
            val response = call.execute()
            postHandler(null, callback, response, params)
        } catch (e: IOException) {
            e.printStackTrace()
            postHandler(null, callback, null, null)
        }
        return call
    }

    /**
     * 处理 post  请求
     *
     * @param request
     * @param callback
     * @param params
     * @return
     */
    private fun doRequest(handler: Handler?, request: Request.Builder, callback: OkNetCallback, params: ParamsCompat): Call {
        val call = mOkHttpClient!!.newCall(request.build())
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                postHandler(handler, callback, null, null)
            }

            override fun onResponse(call: Call, response: Response) {
                postHandler(handler, callback, response, params)
            }
        })
        return call
    }

    companion object {
        const val WRITE_TIMEOUT = 60

        /**
         * 是否需要切换线程
         *
         * @param handler
         * @param callback
         * @param response
         * @param paramsCompat
         */
        private fun postHandler(handler: Handler?, callback: OkNetCallback, response: Response?, paramsCompat: ParamsCompat?) {
            if (handler == null) {
                CoroutineScope(Dispatchers.Main).launch {
                    post(callback, response, paramsCompat)
                }
            } else {
                post(callback, response, paramsCompat)
            }
        }

        /**
         * 回调数据
         *
         * @param callback
         * @param response
         * @param paramsCompat
         */
        private fun post(callback: OkNetCallback, response: Response?, paramsCompat: ParamsCompat?) {
            if (response != null) {
                try {
                    val string = getDecodeResponse(response, paramsCompat)
                    // 错误码二次校验
                    val code = response.code
                    callback.onSuccess(code.toString() + "", string)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } else {
                callback.onFailure("0", "网络连接失败,请检查网络", "")
            }
        }

        /**
         * 解码数据
         *
         * @param response
         * @param paramsCompat
         * @return
         * @throws IOException
         */
        @Throws(IOException::class)
        private fun getDecodeResponse(response: Response, paramsCompat: ParamsCompat?): String {
            // 返回数据进行解码
            var string = ""
            if (paramsCompat == null || paramsCompat.decode.isEmpty()) {
                string = response.body!!.string()
            } else {
                val bytes = response.body!!.bytes()
                string = String(bytes, Charset.forName(paramsCompat.decode)
                )
            }
            return string
        }
    }
}