package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.tree.RowMapper;

import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.mapper.IGenericMapper;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.repository.IGennericRepository;

public class GenericRepository<T> implements IGennericRepository<T> {

	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	//ket noi voi db
	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	// truyen statement de set parameter
	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Date) {
					statement.setDate(index, (Date) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<T> query(String sql, IGenericMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				//results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//-------------------------------------------------------------------------------
	private Class<T> zClass;
	
	@SuppressWarnings("unchecked")
	public GenericRepository() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType)type;
		zClass = (Class<T>)parameterizedType.getActualTypeArguments()[0];
	}
	
	public List<T> findAll() {
		String tableName = "";
		//check xem class co phai entity va table
		if(zClass.isAnnotationPresent(Entity.class) && zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "SELECT * FROM " + tableName +" ";
		List<T> results = new ArrayList<>();
		//tao instanceMapper de map du lieu tu table tra ve
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			return resultSetMapper.mapRow(resultSet, this.zClass);
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

}
