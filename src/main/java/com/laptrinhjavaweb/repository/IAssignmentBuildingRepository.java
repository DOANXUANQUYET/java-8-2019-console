package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.dao.AssignmentBuildingDAO;
import com.laptrinhjavaweb.entity.AssignmentStaffEntity;

public interface IAssignmentBuildingRepository {
	public List<AssignmentBuildingDAO> getAssignmentStaff();
	public Long AssignmentBuildings(AssignmentStaffEntity entity);
}
