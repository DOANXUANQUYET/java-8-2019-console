package com.laptrinhjavaweb.service.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	BuildingRepository buildingRepository = new BuildingRepository();

	@Override
	public List<BuildingEntity> findAll() {
		return buildingRepository.findAll();
	}

	@Override
	public BuildingEntity findOne(Long id) {
		return buildingRepository.findOne(id);
	}

}
