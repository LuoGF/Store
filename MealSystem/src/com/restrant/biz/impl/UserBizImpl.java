package com.restrant.biz.impl;

import java.util.List;

import com.restrant.biz.UserBiz;
import com.restrant.dao.UserDao;
import com.restrant.entity.Admin;
import com.restrant.entity.User;

public class UserBizImpl implements UserBiz {
 public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

private UserDao userDao;
	public List login(User condition) {
		// TODO Auto-generated method stub
		
		return userDao.search(condition);
	}

	public List login(Admin condition) {
		// TODO Auto-generated method stub
		return userDao.search(condition);
	}

}
