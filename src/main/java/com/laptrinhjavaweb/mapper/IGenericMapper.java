package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.util.List;

public interface IGenericMapper<T> {
	//map cac ket qua truy van tu db, Result => modelClass tuong ung
	List<T> mapRow(ResultSet rs,Class<T> zClass);
}
