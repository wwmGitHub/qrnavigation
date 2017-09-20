package com.jy.qrcodemake.service;

import com.jy.qrcodemake.entity.User;
import com.jy.qrcodemake.model.UserModel;

import java.util.List;

public interface UserServiceI {
    /**
     * 用户登录
     * @param user
     * @return
     */
	public UserModel login(UserModel user);

    /**
     * 创建用户
     * @param user
     */
    public void creatUser(User user);

    /**
     * 获取账户list
     * @return
     */
    public List<UserModel> getUserList();


}
