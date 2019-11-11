package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.AssignmentStaffDTO;

public interface IAssignmentBuildingService {
	public List<AssignmentBuildingDTO> getAssignmentStaff();
	public Long AssignmentBuildings(AssignmentStaffDTO dto);

}
