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
    public List<UserModel> getUserList(String username,String password);

    /**
     * 查找user    修改操作使用
     * @param id
     * @return
     */
    public UserModel findUserById(String id,UserModel um,String username,String password);

    /**
     * 保存 修改之后的账号信息
     * @param userName
     * @param userPsss
     * @return
     */
    public Integer saveUser(String userName,String userPsss)throws Exception;

    /**
     * After the user information and qr code data are searched,
     * user information and qr code data are displayed on the page
     * @param um
     * @return
     * @throws Exception
     */
    public UserModel findUser(UserModel um) throws Exception;

}
