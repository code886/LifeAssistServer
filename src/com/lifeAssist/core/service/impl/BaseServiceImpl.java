package com.lifeAssist.core.service.impl;

import java.io.Serializable;
import java.util.List;

import com.lifeAssist.core.dao.BaseDao;
import com.lifeAssist.core.page.PageResult;
import com.lifeAssist.core.service.IBaseService;
import com.lifeAssist.core.util.QueryHelper;

public class BaseServiceImpl<T> implements IBaseService<T>{
	private BaseDao<T> baseDao;
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	@Override
	public T findObjectById(Serializable id) {
		return baseDao.findObjectById(id);
	}

	@Override
	public List<T> findObjects() {
		return baseDao.findObjects();
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		return baseDao.getPageResult(queryHelper, pageNo, pageSize);
	}

}
