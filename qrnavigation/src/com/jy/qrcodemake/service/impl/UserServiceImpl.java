package com.jy.qrcodemake.service.impl;

import com.jy.qrcodemake.dao.CdcDao;
import com.jy.qrcodemake.dao.CdcPlatformBaseDaoI;
import com.jy.qrcodemake.entity.User;
import com.jy.qrcodemake.model.UserModel;
import com.jy.qrcodemake.service.UserServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //将user数据copy到userModel
        UserModel um = new UserModel();
        BeanUtils.copyProperties(user, um);
        cdcDao.createModel(um);
    }

    /**
     * 获取账号list
     * @return
     */
    @Override
    public List<UserModel> getUserList() {
        List<User> list= baseDaoI.find("from User");
        List<UserModel> umList=new ArrayList<>();
        //过滤系统账号
        ListIterator iterator=list.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            User  user= (User) iterator.next();
            if (user.getUserLoginName().equals("admin")){
                iterator.remove();
            }
            if (user!=null) {
                UserModel u = new UserModel();
                BeanUtils.copyProperties(user, u);
                umList.add(u);
            }
        }

        return umList;
    }
}
