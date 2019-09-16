package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageable;
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
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
		// java 7

//		List<BuildingDTO> results = new ArrayList<>();
//		List<BuildingEntity> buildingEntities = buildingRepository.findAll(offset,limit);
//		for (BuildingEntity item : buildingEntities) {
//			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
//			results.add(buildingDTO);
//		}
//		return results;

		// java 8
		//map buider seach vao trong Hashmap , su dung co findAll ben duoi,
		
		//where simple se di vao findAll chung, where dac biet se di vao findAll cua tung doi tuong,
		//vi du vao findAll cua building, hoac findAll cua user....
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("name",fieldSearch.getName());
		properties.put("district",fieldSearch.getDistrict());
		properties.put("buildingArea",fieldSearch.getBuildingArea());
		properties.put("numberOfBasement",fieldSearch.getNumberOfBasement());
		
		// search sau do, convert ket qua entity tra ve qua dto
		return  buildingRepository.findAll(properties,pageable).stream()
				.map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

}
