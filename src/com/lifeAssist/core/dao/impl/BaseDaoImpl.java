package com.lifeAssist.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lifeAssist.core.dao.BaseDao;
import com.lifeAssist.core.page.PageResult;
import com.lifeAssist.core.util.QueryHelper;

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
		return query.list();
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		Query query = getSession().createQuery(queryHelper.getQueryHQL());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters!=null) {
			for(int i=0;i<parameters.size();i++) {//设置参数
				query.setParameter(i, parameters.get(i));
			}
		}
		if(pageNo<1) {//设置起始页号为1
			pageNo = 1;
		}
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		List<?> items = query.list();
		Query queryCount = getSession().createQuery(queryHelper.getQueryCountHQL()); 
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		long totalCount = (long) queryCount.uniqueResult();
		
		return new PageResult(totalCount, pageNo, pageSize, items);
	}
	

}
