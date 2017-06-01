package com.lifeAssist.user.dao;

import java.util.List;

import com.lifeAssist.core.dao.BaseDao;
import com.lifeAssist.user.entity.User;

public interface IUserDao extends BaseDao<User>{

	public List<User> findUserByAccountAndPassword(String account,String password);
	
	public User findUserByAccount(String account);

	public List<User> findUserByAccountAndId(String account, String id);
}
