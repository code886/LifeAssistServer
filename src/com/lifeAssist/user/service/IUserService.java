package com.lifeAssist.user.service;

import java.io.Serializable;
import java.util.List;

import com.lifeAssist.user.entity.User;

public interface IUserService {
	//增加
	public void save(User user);
	//更新
	public void update(User user);
	//根据id删除
	public void delete(Serializable id);
	//根据id查找
	public User findObjectById(Serializable id);
	//查找列表
	public List<User> findObjects();
	// 根据账户名和密码查找
	public User findUserByAccountAndPassword(String account,String password);
	// 检测账户是否已经存在
	public User findUserByAccount(String account);
}
