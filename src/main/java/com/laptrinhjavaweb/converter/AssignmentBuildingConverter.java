package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dao.AssignmentBuildingDAO;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.AssignmentStaffDTO;
import com.laptrinhjavaweb.entity.AssignmentStaffEntity;

public class AssignmentBuildingConverter {
	
	public AssignmentBuildingDTO toDTO(AssignmentBuildingDAO assignmentBuildingDAO) {
		AssignmentBuildingDTO result = new AssignmentBuildingDTO();
		result.setStaffName(assignmentBuildingDAO.getStaffName());
		result.setStaffId(assignmentBuildingDAO.getStaffId());
		if(assignmentBuildingDAO.getAssignmnetBuildings() > 0) {
			result.setChecked("checked");
		}
		return result;
	}
	
	public AssignmentStaffEntity convertToEntity(AssignmentStaffDTO assignmentStaffDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(assignmentStaffDTO,AssignmentStaffEntity.class);
	}
}
