package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.paging.Pageable;

public interface IGennericRepository<T> {
	List<T> findAll(Map<String, Object> properties, Pageable pageable, Object... where);
	List<T> findAll(String sql, Pageable pageable, Object... where);
	Long update(T updateEntity);
	Long insert(T insertEntity);
	int delete(String[] idString);
	T findById(Long id);
	
}
