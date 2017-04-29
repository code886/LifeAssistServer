package com.lifeAssist.user.dao;

import com.lifeAssist.core.dao.BaseDao;
import com.lifeAssist.user.entity.User;

public interface IUserDao extends BaseDao<User>{

	public User findUserByAccountAndPassword(String account,String password);
	
	public User findUserByAccount(String account);
}
