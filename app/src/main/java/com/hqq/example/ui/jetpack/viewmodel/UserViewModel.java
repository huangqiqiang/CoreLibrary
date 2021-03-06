package com.hqq.example.ui.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hqq.example.ui.jetpack.livedata.User;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.example.ui.jetpack.viewmodel
 * @FileName :   UserViewModel
 * @Date : 2020/7/21 0021  上午 9:52
 * @Email : qiqiang213@gmail.com
 * @Descrive :  搭配 LiveData 使用
 */
public class UserViewModel extends ViewModel {

    private MutableLiveData<User> mUser = new MutableLiveData<>();

    public UserViewModel setUser(User user) {
        mUser.setValue(user);
        return this;
    }

    public MutableLiveData<User> getUser() {
        return mUser;
    }

}
