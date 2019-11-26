package com.laptrinhjavaweb.paging;

public interface Pageable {

	Integer getPage();

	Integer getLimit();

	Integer getOffset();
	
	void setTotalPageByRow(Integer rows);
	
	void setTotalPage(Integer totalPage);
	

}
