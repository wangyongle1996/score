package com.service.impl;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.service.IUserService;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
public class UserServiceImpl implements IUserService{
	IUserDao iud = new UserDaoImpl();
	public String queryUser(String userName,String userPwd){
		
			return iud.selectUser(userName, userPwd);
		
	}
}
