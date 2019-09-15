package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
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
	public List<BuildingDTO> findAll(int offset,int limit) {
		// java 7

//		List<BuildingDTO> results = new ArrayList<>();
//		List<BuildingEntity> buildingEntities = buildingRepository.findAll(offset,limit);
//		for (BuildingEntity item : buildingEntities) {
//			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
//			results.add(buildingDTO);
//		}
//		return results;

		// java 8
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("name","tower");
		maps.put("district","QUAN_2");
		maps.put("buildingArea",650);
		maps.put("numberOfBasement",2);
		return  buildingRepository.findAll(maps,offset,limit).stream()
				.map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

}
