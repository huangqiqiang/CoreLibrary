package com.hqq.example.dialog;

import android.view.Gravity;

import androidx.fragment.app.FragmentManager;

import com.hqq.core.ui.dialog.BaseDialog;
import com.hqq.example.R;


/**
 * @version V1.0 <描述当前版本功能>
 * @author: huangqiqiang
 * 在此写用途
 * @FileName: com.hqq.core.app.dialog.RightDialog.java
 * @emain: 593979591@qq.com
 * @date: 2019-07-03 22:22
 */
public class BottomDialog extends BaseDialog {


    public static void showDialog(FragmentManager fragmentManager) {
        BottomDialog fragment = new BottomDialog();
        fragment.show(fragmentManager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_bottom_sheet;
    }

    @Override
    public void initView() {
    }

    @Override
    public int getGravity() {
        return Gravity.BOTTOM;
    }
}
