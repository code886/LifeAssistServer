package com.lifeAssist.core.dao;

import java.io.Serializable;
import java.util.List;

import com.lifeAssist.core.page.PageResult;
import com.lifeAssist.core.util.QueryHelper;

public interface BaseDao<T> {
	//增加
	public void save(T t);
	//更新
	public void update(T t);
	//根据id删除
	public void delete(Serializable id);
	//根据id查找
	public T findObjectById(Serializable id);
	//查找列表
	public List<T> findObjects();
	//分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}
