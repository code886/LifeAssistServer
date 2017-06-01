package com.lifeAssist.core.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	private String fromClause = "";
	private String whereClause = "";
	private String orderByClause = "";
	
	private List<Object> parameters;
	
	public static String ORDER_BY_DESC = "DESC";
	public static String ORDER_BY_ASC = "ASC";
	
	@SuppressWarnings("rawtypes")
	public QueryHelper(Class clazz,String alias) {
		fromClause += "FROM " + clazz.getSimpleName() + " " + alias; 
	}
	
	/**
	 * where子句
	 * @param condition 查询条件
	 * @param params    条件值
	 */
	public void addCondition(String condition, Object... params) {
		if(whereClause.length()>1) {
			whereClause += " AND " + condition;
		}else {
			whereClause += " WHERE " + condition;
		}
		if(parameters==null) {
			parameters = new ArrayList<Object>();
		}
		if(params!=null) {
			for(Object param:params) {
				parameters.add(param);
			}
		}
	}
	
	/**
	 * order by子句
	 * @param property 排序属性
	 * @param order    顺序/逆序
	 */
	public void addOrderByProperty(String property,String order) {
		if(orderByClause.length()>1) {
			orderByClause += ","+property+" "+order;
		}else {
			orderByClause += " ORDER BY " + property + " " + order; 
		}
	}
	
	//返回hql查询语句
	public String getQueryHQL() {
		return fromClause + whereClause + orderByClause;
	}
	
	//查询统计数的hql语句
	public String getQueryCountHQL() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	//条件查询的条件集合
	public List<Object> getParameters(){
		return parameters;
	} 
}
