package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

public interface IGenericMapperVersion1<T> {
	//map cac ket qua truy van tu db, Result => modelClass tuong ung
	T mapRow(ResultSet result);
}
