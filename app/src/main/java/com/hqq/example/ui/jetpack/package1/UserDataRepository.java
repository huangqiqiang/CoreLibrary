package com.hqq.example.ui.jetpack.package1;

import com.hqq.example.ui.jetpack.livedata.User;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.example.ui.jetpack.package1
 * @FileName :   UserDataRepository
 * @Date : 2020/7/21 0021  下午 4:19
 * @Email : qiqiang213@gmail.com
 * @Descrive :  数据源
 */
class UserDataRepository {


    public User getUser() {
        return User.newInstance();
    }



}
