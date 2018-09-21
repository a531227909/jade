package com.jade.uitil;

import java.util.List;
import java.util.Map;

public class PageBean<T> {

	private int pageNum;//当前页码
	private int tr;//总记录数
	private int pageSize;//每页记录数
//	private String url;//请求路径和参数，例如：/BookServlet?method=findXXX&cid=1&bname=2
	private List<Map<String, Object>> beanList;
	
	public int getTp(){
		int tp = tr / pageSize;
		return tr % pageSize ==0 ? tp : tp + 1;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
/*	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}*/
	public List<Map<String, Object>> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<Map<String, Object>> list) {
		this.beanList = list;
	}
}
