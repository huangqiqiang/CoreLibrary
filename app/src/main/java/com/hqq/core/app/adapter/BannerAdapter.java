package com.hqq.core.app.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hqq.core.app.R;
import com.hqq.core.glide.ImageLoadUtils;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.coreapp.adapter
 * @FileName :   BannerAdapter
 * @Date : 2018/12/20 0020  下午 3:32
 * @Descrive :
 * @Email :  qiqiang213@gmail.com
 */
public class BannerAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public BannerAdapter() {
        super(R.layout.item_banner_adapter);
    }
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageLoadUtils.with("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg", (ImageView) helper.getView(R.id.iv_banner));
    }
}