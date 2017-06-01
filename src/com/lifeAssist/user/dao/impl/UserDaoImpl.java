package com.lifeAssist.user.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import com.lifeAssist.core.dao.impl.BaseDaoImpl;
import com.lifeAssist.user.dao.IUserDao;
import com.lifeAssist.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{
	
	@Override
	public List<User> findUserByAccountAndPassword(String account, String password) {
		String query = "from User where account=:myName and password=:myPassword";
		String paramNames[] = {"myName","myPassword"};
		String values[] = {account,password};
		List<User> list = getHibernateTemplate().findByNamedParam(query, paramNames, values);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public User findUserByAccount(String account) {
		String query = "from User where account=:myName";
		String paramNames[] = {"myName"};
		String values[] = {account};
		List<User> list = getHibernateTemplate().findByNamedParam(query, paramNames, values);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> findUserByAccountAndId(String account, String id) {
		String hql = "from User where account = ?";
		if(StringUtils.isNotBlank(id)) {
			hql += "and id != ?";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);
		if(StringUtils.isNotBlank(id)) {
			query.setParameter(1, id);
		}
		return query.list();
	}
	
}
