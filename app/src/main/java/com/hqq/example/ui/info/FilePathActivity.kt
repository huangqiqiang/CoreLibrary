package com.hqq.example.ui.info

import android.widget.TextView
import com.hqq.core.ui.base.BaseActivity
import com.hqq.core.utils.FilePathUtils.externalStorageDirectory
import com.hqq.core.utils.FilePathUtils.getCacheDir
import com.hqq.core.utils.FilePathUtils.getExternalCacheDir
import com.hqq.core.utils.FilePathUtils.getExternalFilesDir
import com.hqq.core.utils.FilePathUtils.getFileStreamPath
import com.hqq.core.utils.FilePathUtils.getFilesDir
import com.hqq.core.utils.FilePathUtils.getSdCardExternalStoragePublicDirectory
import com.hqq.core.utils.FilePathUtils.path4Data
import com.hqq.core.utils.FilePathUtils.sdCardExternalStorageDirectory
import com.hqq.core.utils.FilePathUtils.sdCardExternalStoragePublicDirectory
import com.hqq.core.utils.TextSpannableBuilder
import com.hqq.example.R

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.example.ui.info
 * @FileName :   FilePathActivity
 * @Date : 2019/11/29 0029  上午 10:23
 * @Email :  qiqiang213@gmail.com
 * @Descrive :
 */
class FilePathActivity : BaseActivity() {
    lateinit var mTvInfo: TextView
    override val layoutViewId: Int = R.layout.activity_base_info

    override fun initView() {
        mTvInfo = findViewById(R.id.tv_info)
        mTvInfo.setText(TextSpannableBuilder()
                .addTextPart("\nEnvironment.getDataDirectory()    ")
                .addTextPart("\n")
                .addTextPart(path4Data)
                .addTextPart("\n")
                .addTextPart("\nContext.getCacheDir()  ")
                .addTextPart("\n")
                .addTextPart(getCacheDir(this))
                .addTextPart("\n")
                .addTextPart("\nContext.getFilesDir()  ")
                .addTextPart("\n")
                .addTextPart(getFilesDir(this))
                .addTextPart("\n")
                .addTextPart("\nContext.getFileStreamPath()  ")
                .addTextPart("\n")
                .addTextPart(getFileStreamPath(this))
                .addTextPart("\n")
                .addTextPart("\nContext.getFileStreamPath()  ")
                .addTextPart("\n")
                .addTextPart(getFileStreamPath(this, "fileName"))
                .addTextPart("\n")
                .addTextPart("\nContext.getExternalStorageDirectory()  ")
                .addTextPart("\n")
                .addTextPart(externalStorageDirectory)
                .addTextPart("\n")
                .addTextPart("\nContext.getExternalCacheDir()  ")
                .addTextPart("\n")
                .addTextPart(getExternalCacheDir(this))
                .addTextPart("\n")
                .addTextPart("\nContext.getExternalFilesDir()  ")
                .addTextPart("\n")
                .addTextPart(getExternalFilesDir(this))
                .addTextPart("\n")
                .addTextPart("\nContext.getExternalFilesDir()  ")
                .addTextPart("\n")
                .addTextPart(getExternalFilesDir(this, "fileName"))
                .addTextPart("\n")
                .addTextPart("\nContext.getSdCardExternalStorageDirectory()  ")
                .addTextPart("\n")
                .addTextPart(sdCardExternalStorageDirectory)
                .addTextPart("\n")
                .addTextPart("\nContext.getSdCardExternalStoragePublicDirectory()  ")
                .addTextPart("\n")
                .addTextPart(sdCardExternalStoragePublicDirectory)
                .addTextPart("\n")
                .addTextPart("\nContext.getSdCardExternalStoragePublicDirectory()  ")
                .addTextPart("\n")
                .addTextPart(getSdCardExternalStoragePublicDirectory("fileName"))
                .addTextPart("\n")
                .addTextPart("\n  ")
                .addTextPart("")
                .build())
    }
}