package com.hqq.example.ui.adaptation

import android.app.Activity
import android.content.Intent
import com.hqq.core.glide.ImageLoadUtils
import com.hqq.core.ui.base.BaseViewBindingActivity
import com.hqq.example.databinding.ActivityDefImgBinding

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.core.app.ui.activity
 * @FileName :   DefImgActivity
 * @Date : 2019/7/18 0018  下午 3:52
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 */
class DefImgActivity : BaseViewBindingActivity<ActivityDefImgBinding>() {
    companion object {
        fun open(context: Activity) {
            context.startActivityForResult(Intent(context, DefImgActivity::class.java), -1)
        }
    }

    override fun initView() {

        ImageLoadUtils.with("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", binding.ivGif)
        ImageLoadUtils.withFillet("https://img.jbzj.com/file_images/article/202010/2020101810184374.png", binding.imageView11)
        ImageLoadUtils.withFillet2PX("https://img.jbzj.com/file_images/article/202010/2020101810184374.png", binding.imageView12,100)

    }
}