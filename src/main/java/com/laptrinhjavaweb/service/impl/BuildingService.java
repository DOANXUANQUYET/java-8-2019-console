package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	private BuildingRepository buildingRepository;
	private BuildingConverter buildingConverter;

	public BuildingService() {
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
	}

	@Override
	public List<BuildingDTO> findAll() {
		// java 7

		List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
			results.add(buildingDTO);
		}
		return results;

		// java 8
//		return buildingRepository.findAll().stream()
//				.map(item -> buildingConverter.convertToDTO(item).collect(Collectors.toList()));
	}

}
