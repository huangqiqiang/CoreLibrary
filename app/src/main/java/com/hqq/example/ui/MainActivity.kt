package com.hqq.example.ui

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.hqq.core.net.ok.OkHttp
import com.hqq.core.net.ok.OkNetCallback
import com.hqq.core.ui.list.BaseListViewModel
import com.hqq.core.ui.list.BaseVmListActivity
import com.hqq.core.utils.GsonUtil
import com.hqq.core.utils.ToastUtils
import com.hqq.core.utils.log.LogUtils
import com.hqq.example.adapter.MainAdapter
import com.hqq.example.bean.MainBean
import com.hqq.example.demo.DemoIndexActivity
import com.hqq.example.demo.login.LoginActivity
import com.hqq.example.ui.MainActivity.MainViewModel
import com.hqq.example.ui.adaptation.AdaptationIndexActivity
import com.hqq.example.ui.adaptation.DefImgActivity
import com.hqq.example.ui.adaptation.PermissionActivity
import com.hqq.example.ui.bar.ToolBarActivity
import com.hqq.example.ui.customize.CustomizeIndexActivity
import com.hqq.example.ui.dialog.TestDialogActivity
import com.hqq.example.ui.exception.ThrowActivity
import com.hqq.example.ui.info.BaseInfoActivity
import com.hqq.example.ui.info.FilePathActivity
import com.hqq.example.ui.jetpack.livedata.LiveDateActivity
import com.hqq.example.ui.jetpack.room.RoomActivity
import com.hqq.example.ui.launch.mode.SingleInstanceActivity
import com.hqq.example.ui.recycle.RecycleIndexActivity
import com.hqq.example.ui.skin.SkinAActivity
import com.hqq.example.ui.transitions.animation.TransitionsAnimationActivity
import com.hqq.example.ui.view.BlackAndWhiteActivity
import com.hqq.example.ui.view.SvgActivity
import com.hqq.example.ui.web.WebActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.iblibrary
 * @FileName :   MainActivity
 * @Date : 2018/11/22 0022
 * @Descrive : TODO
 * @Email :  qiqiang213@gmail.com
 */
@AndroidEntryPoint
class MainActivity : BaseVmListActivity<MainViewModel, ViewDataBinding>() {
    //  ?????????kotlin
    override val adapter: MainAdapter = MainAdapter()
    override val bindingViewModelId: Int
        get() = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtils.e("MainActivity    onCreate1")
        super.onCreate(savedInstanceState)
        LogUtils.e("MainActivity    onCreate2")
    }

    override fun initData() {
        LogUtils.e("MainActivity    initData")
//        loadingView.show()
//        Handler().postDelayed(3 * 1000) {
//            MyPopupWindow(this).showPopupWindow(iCreateRootView.rootView);
//
//        }
//        startActivity(Intent(this, LoginActivity::class.java))
//        RoomActivity.open(this)
//        SoftHideKeyboardScrollView.getNavigationBarHeight(this)
//        SoftHideKeyboardScrollView.checkDeviceHasNavigationBar(this)

        onBooks()
    }


    fun onBooks() {
        OkHttp.newHttpCompat()
                .get("http://search.zongheng.com/search/suggest?keyword=???",
                        OkHttp.newParamsCompat(),
                        object : OkNetCallback {
                            override fun onSuccess(statusCode: String?, response: String?) {
                                LogUtils.e(response)
                            }

                            override fun onFailure(statusCode: String?, errMsg: String?, response: String?) {
                            }
                        })
    }


    val mV: MainViewModel by viewModels()

    private var mExitTime: Long = 0
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN && event.repeatCount == 0) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                ToastUtils.showToast("????????????????????????")
                mExitTime = System.currentTimeMillis()
            } else {
                val mHomeIntent = Intent(Intent.ACTION_MAIN)
                mHomeIntent.addCategory(Intent.CATEGORY_HOME)
                mHomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                startActivity(mHomeIntent)
                // ????????????
                System.exit(0)
            }
            return true
        }
        return super.dispatchKeyEvent(event)
    }

    val mVl: MainViewModel by viewModels()

    override fun getViewModel(): MainViewModel {
        return mVl
    }

    class MainViewModel @ViewModelInject constructor() : BaseListViewModel() {
        init {
            LogUtils.e("MainModel init 1  ")
            viewModelScope.launch {
                LogUtils.e("MainModel init viewModelScope")
            }
            LogUtils.e("MainModel init 2")
        }

        override fun initData(extras: Bundle?) {
            super.initData(extras)
            LogUtils.e("MainModel initData 1")
        }

        override fun onCrete() {
            LogUtils.e("MainModel onCrete 1")
            super.onCrete()
            LogUtils.e("MainModel onCrete 2")
            val arrayList = mutableListOf<MainBean<*>>()
            arrayList.add(MainBean("????????????", SingleInstanceActivity::class.java))
            arrayList.add(MainBean("????????????", TransitionsAnimationActivity::class.java))
            arrayList.add(MainBean("??????/???????????????", ToolBarActivity::class.java))
            arrayList.add(MainBean("???????????????", DefImgActivity::class.java))
            arrayList.add(MainBean("Recycle ??????", RecycleIndexActivity::class.java))
            arrayList.add(MainBean("????????????", PermissionActivity::class.java))
            arrayList.add(MainBean("Dialog??????", TestDialogActivity::class.java))
            arrayList.add(MainBean("Shape??????", ShapeTestActivity::class.java))
            arrayList.add(MainBean("???????????????", CustomizeIndexActivity::class.java))
            arrayList.add(MainBean("????????????", BaseInfoActivity::class.java))
            arrayList.add(MainBean("????????????", WebActivity::class.java))
            arrayList.add(MainBean("??????????????????", FilePathActivity::class.java))
            arrayList.add(MainBean("????????????", AdaptationIndexActivity::class.java))
            arrayList.add(MainBean("DateBinding??????", LiveDateActivity::class.java))
            arrayList.add(MainBean("Throw????????????", ThrowActivity::class.java))
            arrayList.add(MainBean("???????????????", BlackAndWhiteActivity::class.java))
            arrayList.add(MainBean("????????????", SkinAActivity::class.java))
            arrayList.add(MainBean("SVG??????", SvgActivity::class.java))
            arrayList.add(MainBean("demo??????", DemoIndexActivity::class.java))
            setData(arrayList)

        }
    }


}
