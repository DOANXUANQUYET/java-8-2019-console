package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class ResultSetMapper<T> implements IGenericMapper<T> {

	@Override
	public List<T> mapRow(ResultSet rs, Class<T> zClass) {
		List<T> result = new ArrayList<>();
		try {
			// kiem tra xem mapClass co phai entity hay k?
			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				Field[] allFields = zClass.getDeclaredFields();
				// duyet tung row trong table tra ve
				while (rs.next()) {
					// tao object de chua row trong table voi moi lan duyet
					T object = zClass.newInstance();
					// duyet tung column trong table tra ve
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1); // trung resultSet index chay tu 1
						Object columnValue = rs.getObject(i + 1);
						//de giam tham so truyen vao ham convertResult
						ColumnModel columnModel = new ColumnModel();
						columnModel.setColumnName(columnName);
						columnModel.setColumnValue(columnValue);
						convertResultSetToEntity(allFields, columnModel, object);
						// duyet field cua cac class parent cua mapclass----------------------------
						Class<?> parentClass = zClass.getSuperclass();
						while (parentClass != null) {
							Field[] fieldParent = parentClass.getDeclaredFields();
							convertResultSetToEntity(fieldParent, columnModel, object);
							parentClass = parentClass.getSuperclass();
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

	private void convertResultSetToEntity(Field[] fields, ColumnModel columnModel, Object... objects) {
		@SuppressWarnings("unchecked")
		T object = (T)objects[0];
		try {
			// duyet tung field trong mapClass, tim field trung voi ten column de map
			for (Field field : fields) {
				Column column = field.getAnnotation(Column.class);
				// field trong map class trung voi ten column trong table va phai chua gia tri
				if (column.name().equals(columnModel.getColumnName()) && columnModel.getColumnValue() != null) {
					// convert data (entity, columnName trong entity, columnValue)
					BeanUtils.setProperty(object, field.getName(), columnModel.getColumnValue());
					break;
				}
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static class ColumnModel {
		private String columnName;
		private Object columnValue;	
		
		public String getColumnName() {
			return columnName;
		}
		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}
		public Object getColumnValue() {
			return columnValue;
		}
		public void setColumnValue(Object columnValue) {
			this.columnValue = columnValue;
		}
	}

}
