package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.converter.AssignmentBuildingConverter;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.AssignmentStaffDTO;
import com.laptrinhjavaweb.repository.IAssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.impl.AssignmentStaffRepository;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;

public class AssignmentBuildingService implements IAssignmentBuildingService {

	private static IAssignmentBuildingRepository repository = new AssignmentStaffRepository();
	private static AssignmentBuildingConverter convert = new AssignmentBuildingConverter();

	@Override
	public Long AssignmentBuildings(AssignmentStaffDTO dto) {
		return repository.AssignmentBuildings(convert.convertToEntity(dto));
	}

	@Override
	public List<AssignmentBuildingDTO> getAssignmentStaff() {
		return repository.getAssignmentStaff().stream().map(item -> convert.toDTO(item)).collect(Collectors.toList());
	}

}
