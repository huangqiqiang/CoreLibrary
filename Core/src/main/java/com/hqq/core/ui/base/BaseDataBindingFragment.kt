package com.hqq.core.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hqq.core.ui.base.IRootView.IBanding

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.ui.binding
 * @FileName :   BaseBindingFragment
 * @Date : 2020/7/30 0030  上午 10:54
 * @Email : qiqiang213@gmail.com
 * @Descrive :    ViewBinding  与DataBinding 至今是有性能上的差别
 * DataBinding 需要标识xml 支持双向绑定 以及 布局中声明动态界面内容
 */
abstract class BaseDataBindingFragment<T : ViewDataBinding> : BaseFragment(), IBanding {
    /**
     *   DataBinding 对象
     */
    lateinit var binding: T

    /**
     *  布局ID
     */
    override val layoutViewId: Int = 0

    /**
     *  重写
     */
    override fun getLayoutView(parent: ViewGroup): View {
        binding = DataBindingUtil.inflate<T>(layoutInflater, layoutId, parent, false).apply {
            lifecycleOwner = this@BaseDataBindingFragment
        }
        return binding.root
    }
}