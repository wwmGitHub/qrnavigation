package com.jy.qrcodemake.service.impl;

import com.jy.qrcodemake.dao.CdcDao;
import com.jy.qrcodemake.dao.CdcPlatformBaseDaoI;
import com.jy.qrcodemake.entity.User;
import com.jy.qrcodemake.model.UserModel;
import com.jy.qrcodemake.service.UserServiceI;
import com.jy.qrcodemake.util.Unid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

@Service
public class UserServiceImpl implements UserServiceI{
	private CdcDao cdcDao;
    private CdcPlatformBaseDaoI baseDaoI;
	@Autowired
	public UserServiceImpl(CdcDao cdcDao,CdcPlatformBaseDaoI baseDaoI)
	{
		this.cdcDao = cdcDao;
        this.baseDaoI=baseDaoI;
	}
	
	@Override
	public UserModel login(UserModel user) {
		List<User> list = cdcDao.hqlQueryWithParams(" from User where  user_login_name = '"+user.getUserLoginName()+"' and user_login_pass='"+user.getUserLoginPass()+"'", new HashMap());
		if(list.size()>0){
			UserModel u = new UserModel();
			BeanUtils.copyProperties(list.get(0), u);
		
			return u;
		}else{
			return null;
		}		
	}

    /**
     * 用户创建
     * @param user
     */
    @Override
    public void creatUser(User user) {

        cdcDao.createModel(user);
    }

    /**
     * 获取账号list
     * @return
     */
    @Override
    public List<UserModel> getUserList(String username,String password) {
        List<User> list= baseDaoI.find("from User");
        List<UserModel> umList=new ArrayList<>();
        //过滤系统账号
        ListIterator iterator=list.listIterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            User  user= (User) iterator.next();
            if (user.getUserLoginName().equals(username)){
                iterator.remove();
            }
            if (user!=null&&!user.getUserLoginName().equals(username)) {
                UserModel u = new UserModel();
                BeanUtils.copyProperties(user, u);
                umList.add(u);
            }
        }

        return umList;
    }

    /**
     * find   修改操作时用
     * @param id
     * @return
     */
    @Override
    public UserModel findUserById(String id,UserModel um,String username,String password) {
        if (id!=null){
            String hql="from User where userId='"+id+"'";
            User user = (User) baseDaoI.get(hql);
            //user转换成model对象
            if(user!=null&&!user.getUserLoginName().equals("")) {
                UserModel u = new UserModel();
                BeanUtils.copyProperties(user, u);
                return u;
            }
        }
        if (um!=null){
            String hql="from User where user_login_name='"+um.getUserLoginName()+"' user_login_pass='"+um.getUserLoginPass()+"'";
            User user = (User) baseDaoI.get(hql);
            if (user!=null){
                UserModel u = new UserModel();
                BeanUtils.copyProperties(user, u);
                return u;

            }
        }
        if (username!=null&&!username.equals("")&&password!=null&&!password.equals("")){
            String hql="from User where user_login_name='"+username+"' and user_login_pass='"+password+"'";
            User user = (User) baseDaoI.get(hql);
            if (user!=null){
                UserModel u = new UserModel();
                BeanUtils.copyProperties(user, u);
                return u;
            }
        }
        return null;
    }

    /**
     * 保存  修改之后的账号信息
     * @param userName
     * @param userPsss
     * @return
     */
    @Override
    public Integer saveUser(String userName, String userPsss)throws Exception {
        User user = new User();
        user.setUserId(Unid.GetUnidO());
        user.setUserLoginName(userName);
        user.setUserLoginPass(userPsss);
        String uuid= (String) baseDaoI.save(user);
        if (uuid.isEmpty()&&uuid.equals("")){
            return 1;
        }
        return null;

    }

    @Override
    public UserModel findUser(UserModel um) throws Exception {

        return null;
    }


}
