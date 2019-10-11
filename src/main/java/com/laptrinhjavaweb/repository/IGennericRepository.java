package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.paging.Pageable;

public interface IGennericRepository<T> {
	List<T> findAll(Map<String, Object> properties, Pageable pageable, Object... where);
	List<T> findAll(String sql, Pageable pageable, Object... where);
	void update(String sql,Object... parameters);
	Long insert(String sql,Object... parameters);
	
}
