package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class ResultSetMapper<T> implements IGenericMapper<T> {

	@Override
	public List<T> mapRow(ResultSet rs,Class<T> zClass) {
		List<T> result = new ArrayList<>();
		try {	
			//kiem tra xem mapClass co phai entity hay k?
			if(zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				Field[] allFields = zClass.getDeclaredFields();
				//duyet tung row trong table tra ve
				while(rs.next()) {	
					//tao object de chua row trong table voi moi lan duyet
					T object = zClass.newInstance();
					//duyet tung column trong table tra ve
					for(int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1); //trung resultSet index chay tu 1
						Object columnValue = rs.getObject(i + 1);
						//duyet tung field trong mapClass, tim field trung voi ten column de map
						for(Field field : allFields) {
							Column column = field.getAnnotation(Column.class);
							//field trong map class trung voi ten column trong table va phai chua gia tri
							if(column.name().equals(columnName) && columnValue != null) {
								//convert data (entity, columnName trong entity, columnValue)
								BeanUtils.setProperty(object, field.getName(), columnValue);
								break;
							}
						}
					}
					result.add(object);
				}
			}
			
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		return result;
	}

}
