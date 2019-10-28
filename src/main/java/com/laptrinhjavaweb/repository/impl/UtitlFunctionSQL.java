package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;

public class UtitlFunctionSQL {

	public void setParameterUpdate(PreparedStatement statement, Object entity) {
		try {
			// create arrayParamsValue
			Class<?> aClass = entity.getClass();
			Field[] fields = aClass.getDeclaredFields();
			int updateIndex = 1;
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				// cap quyen de thao tac len field private
				field.setAccessible(true);
				if (field.get(entity) != null) {
					statement.setObject(updateIndex, field.get(entity));
					updateIndex++;
				}
			}

			Class<?> parentClass = aClass.getSuperclass();
			while (parentClass != null) {
				Field[] parentFields = parentClass.getDeclaredFields();
				for (int i = 0; i < parentFields.length; i++) {
					Field field = parentFields[i];
					// cap quyen de thao tac len field private
					field.setAccessible(true);
					if (field.get(entity) != null && !field.getName().equals("id")) {
						statement.setObject(updateIndex, field.get(entity));
						updateIndex++;
					}
				}
				parentClass = parentClass.getSuperclass();
			}
		} catch (SQLException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setParameterInsert(PreparedStatement statement, Object entity) {
		try {
			// create arrayParamsValue
			Class<?> aClass = entity.getClass();
			Field[] fields = aClass.getDeclaredFields();
			int index = 1;
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				// cap quyen de thao tac len field private
				field.setAccessible(true);
				statement.setObject(index, field.get(entity));
				index++;
			}
			Class<?> parentClass = aClass.getSuperclass();
			while (parentClass != null) {
				Field[] parentFields = parentClass.getDeclaredFields();
				for (int i = 0; i < parentFields.length; i++) {
					Field field = parentFields[i];
					// cap quyen de thao tac len field private
					field.setAccessible(true);
					statement.setObject(index, field.get(entity));
					index++;
				}
				parentClass = parentClass.getSuperclass();
			}
		} catch (SQLException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String createSQLInsert(Class<?> zClass) {
		String tableName = "";
		// check xem class co phai entity va table
		if (zClass.isAnnotationPresent(Entity.class) && zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder();
		StringBuilder params = new StringBuilder();
		// create filesString and valueString from ClassEntity of fields
		for (Field field : zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		String sql = "INSERT INTO " + tableName + " (" + fields.toString() + ") VALUES(" + params.toString() + ")";
		return sql;
	}

	public String createSQLUpdate(Class<?> zClass, Object entity) {
		String tableName = "";
		Long id = -1L;
		// check xem class co phai entity va table
		if (zClass.isAnnotationPresent(Entity.class) && zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder();
		// create filesString and valueString from ClassEntity of fields
		for (Field field : zClass.getDeclaredFields()) {
			try {
				field.setAccessible(true);
				if (field.get(entity) == null) {
					continue;
				}
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
			if (fields.length() > 1) {
				fields.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name() + " = ? ");
			}
		}
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				try {
					field.setAccessible(true);
					if (field.get(entity) == null) {
						continue;
					}
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column.name().equals("id")) {
						try {
							field.setAccessible(true);
							id = (Long) field.get(entity);
							continue;
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
					if (fields.length() > 1) {
						fields.append(",");
					}
					fields.append(column.name() + " = ? ");
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		String sql = "UPDATE " + tableName + " SET  " + fields.toString() + " WHERE id = " + id + "";
		return sql;
	}

}
