package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

public interface IGenericMapper<T> {
	//map cac ket qua truy van tu db, Result => modelClass tuong ung
	T mapRow(ResultSet result);
}
