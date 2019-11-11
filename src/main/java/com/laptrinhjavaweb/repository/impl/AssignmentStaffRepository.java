package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.AssignmentBuildingDAO;
import com.laptrinhjavaweb.entity.AssignmentStaffEntity;
import com.laptrinhjavaweb.repository.IAssignmentBuildingRepository;

public class AssignmentStaffRepository extends GenericRepository<AssignmentStaffEntity> implements IAssignmentBuildingRepository {

	@Override
	public List<AssignmentBuildingDAO> getAssignmentStaff() {
		String sql = "SELECT staff.id, staff.staffname,COUNT(assignmentstaff.buildingid) AS buildings FROM staff "
				+ " LEFT JOIN assignmentstaff ON staff.id = assignmentstaff.staffid "
				+ " GROUP BY staff.id ORDER BY staff.id;";
		// tao instanceMapper de map du lieu tu table tra ve
		List<AssignmentBuildingDAO> resultSetMapper = new ArrayList<AssignmentBuildingDAO>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				// tao object de chua row trong table voi moi lan duyet
				AssignmentBuildingDAO object = new AssignmentBuildingDAO();
				object.setStaffId(resultSet.getLong("id"));
				object.setStaffName(resultSet.getString("staffname"));
				object.setAssignmnetBuildings(resultSet.getLong("buildings"));				
				resultSetMapper.add(object);
				}
			return resultSetMapper;
		} catch (SQLException e) {
			return new ArrayList<>();
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
				return new ArrayList<>();
			}
		}
	}

	@Override
	public Long AssignmentBuildings(AssignmentStaffEntity entity) {
		return this.insert(entity);
	}


}
