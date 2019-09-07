package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.mapper.IGenericMapperVersion1;

public interface IGennericRepositoryVersion1<T> {
	List<T> query(String sql, IGenericMapperVersion1<T> rowMapper, Object... parameters);
	void update(String sql,Object... parameters);
	Long insert(String sql,Object... parameters);
	
}
