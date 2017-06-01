package com.lifeAssist.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lifeAssist.core.service.impl.BaseServiceImpl;
import com.lifeAssist.user.dao.IUserDao;
import com.lifeAssist.user.entity.User;
import com.lifeAssist.user.service.IUserService;

@Service("userService")
public class UserService extends BaseServiceImpl<User> implements IUserService{

	private IUserDao userDao;
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		super.setBaseDao(userDao);
	}

	@Override
	public List<User> findUserByAccountAndPassword(String account, String password) {
		return userDao.findUserByAccountAndPassword(account, password);
	}

	@Override
	public User findUserByAccount(String account) {
		return userDao.findUserByAccount(account);
	}
	
	@Override
	public List<User> findUserByAccountAndId(String account, String id) {
		return userDao.findUserByAccountAndId(account,id);
	}
	
}
