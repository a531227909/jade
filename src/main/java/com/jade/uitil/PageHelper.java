package com.jade.uitil;


public class PageHelper {

	private int page ;			
	private int rows ;			
	private String sort = null ;
	private String order = "asc" ;
	private int start ;			
	private int end ;			
	private String searchName;
	private String searchValue;
	private String leaveName;
	private String courseTeacher;
	
	
	
	public String getLeaveName() {
		return leaveName;
	}



	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}



	public String getCourseTeacher() {
		return courseTeacher;
	}



	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}



	public String getSearchName() {
		return searchName;
	}



	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}



	public String getSearchValue() {
		return searchValue;
	}



	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}



	public int getPage() {
		return page;
	}

	
	
	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
