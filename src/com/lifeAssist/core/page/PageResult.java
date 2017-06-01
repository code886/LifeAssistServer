package com.lifeAssist.core.page;

import java.util.ArrayList;
import java.util.List;

public class PageResult {
	// 总记录数
	private long totalCount;
	// 当前页号
	private int pageNo;
	// 页面大小
	private int pageSize;
	// 总页数
	private int pageCount;
	// 列表记录
	private List<?> items;

	// 计算总页数
	public PageResult(long totalCount, int pageNo, int pageSize, List<?> items) {
		this.items = items == null ? new ArrayList<>() : items;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		if (totalCount != 0) {
			int temp = (int) totalCount / pageSize;
			this.pageCount = (totalCount % pageSize == 0) ? temp : temp + 1;
			this.pageNo = pageNo;
		} else {
			this.pageNo = 0;
		}
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

}
