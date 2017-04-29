package com.lifeAssist.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lifeAssist.core.dao.BaseDao;

public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	Class<T> clazz;
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();//BaseDaoImpl<User>
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findObjectById(id));
	}

	@Override
	public T findObjectById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findObjects() {
		Query query = getSession().createQuery("FROM " + clazz.getSimpleName() );
		//System.out.println(clazz.getSimpleName());
		return query.list();
	}

}
