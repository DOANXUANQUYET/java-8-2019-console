package com.laptrinhjavaweb.service.impl;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	BuildingRepository buildingRepository = new BuildingRepository();

	@Override
	public List<BuildingDTO> findAll() {
		return buildingRepository.findAll();
	}

	@Override
	public BuildingDTO findOne(Long id) {
		return buildingRepository.findOne(id);
	}

}
