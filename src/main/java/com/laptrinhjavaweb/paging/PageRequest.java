package com.laptrinhjavaweb.paging;

public class PageRequest implements Pageable {
	
	private Integer page;
	private Integer limit;
	private Integer totalPage;

	public PageRequest(Integer page, Integer limit) {
		super();
		this.page = page;
		this.limit = limit;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getLimit() {
		return this.limit;
	}

	@Override
	public Integer getOffset() {
		return (this.page - 1) * this.limit;
	}
	
	public Integer getTotalPage() {
		return this.totalPage;
	}

	@Override
	public void setTotalPageByRow(Integer rows) {
		if(rows % limit  !=  0) {
			this.totalPage = rows / limit + 1;
		}else {
			this.totalPage = rows / limit;
		}
	}

	@Override
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;		
	}


}
