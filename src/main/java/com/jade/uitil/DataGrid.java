package com.jade.uitil;

import java.util.List;

/**
 * 后台向前台返回JSON
 * 
 * @author 
 * 
 */
public class DataGrid {

	private Long total;	// 总记录数
	private List rows;	// 每行记录
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
