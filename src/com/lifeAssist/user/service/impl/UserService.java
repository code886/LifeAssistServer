package com.lifeAssist.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lifeAssist.user.dao.IUserDao;
import com.lifeAssist.user.entity.User;
import com.lifeAssist.user.service.IUserService;

@Service("userService")
public class UserService implements IUserService{

	@Resource
	private IUserDao userDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
	}

	@Override
	public User findObjectById(Serializable id) {
		return userDao.findObjectById(id);
	}

	@Override
	public List<User> findObjects() {
		return userDao.findObjects();
	}

	@Override
	public User findUserByAccountAndPassword(String account, String password) {
		return userDao.findUserByAccountAndPassword(account, password);
	}

	@Override
	public User findUserByAccount(String account) {
		return userDao.findUserByAccount(account);
	}
	
	
}
