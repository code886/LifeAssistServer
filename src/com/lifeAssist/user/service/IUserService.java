package com.lifeAssist.user.service;

import java.util.List;

import com.lifeAssist.core.service.IBaseService;
import com.lifeAssist.user.entity.User;

public interface IUserService extends IBaseService<User>{
	// 根据账户名和密码查找
	public List<User> findUserByAccountAndPassword(String account,String password);
	// 检测账户是否已经存在
	public User findUserByAccount(String account);
	//根据帐号和id查询用户
	public List<User> findUserByAccountAndId(String account, String id);
}
