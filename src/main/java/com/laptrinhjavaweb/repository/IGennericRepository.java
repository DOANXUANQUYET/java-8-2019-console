package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.mapper.IGenericMapper;

public interface IGennericRepository<T> {
	List<T> query(String sql, IGenericMapper<T> rowMapper, Object... parameters);
	void update(String sql,Object... parameters);
	Long insert(String sql,Object... parameters);
	
}
