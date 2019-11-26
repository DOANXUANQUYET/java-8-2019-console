package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
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
		// search sau do, convert ket qua entity tra ve qua dto
		Map<String, Object> properties = convertToMapProperties(fieldSearch);
		return buildingRepository.findAll(properties, pageable, fieldSearch).stream()
				.map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	private Map<String, Object> convertToMapProperties(BuildingSearchBuilder fieldSearch) {
		// java 8
		// map buider seach vao trong Hashmap , su dung co findAll ben duoi,

		// where simple se di vao findAll chung, where dac biet se di vao findAll cua
		// tung doi tuong,
		// vi du vao findAll cua building, hoac findAll cua user....
		Map<String, Object> properties = new HashMap<String, Object>();
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				if (!field.getName().equals("buildingTypes") && !field.getName().startsWith("costRent")
						&& !field.getName().startsWith("areaRent") && !field.getName().equals("staffId")) {

					// can phai cap quyen cho field voi modifier la private
					field.setAccessible(true);
					// field.get(ten kieu du lieu) --> tra ve gia tri cua field
					if (field.get(fieldSearch) instanceof String) {
						if (field.getName().equals("buildingArea") || field.getName().equals("numberOfBasement")) {
							if (StringUtils.isNotBlank((String) field.get(fieldSearch))) {
								properties.put(field.getName().toLowerCase(),
										Integer.parseInt((String) field.get(fieldSearch)));
							}
						} else {
							properties.put(field.getName().toLowerCase(), field.get(fieldSearch));
						}
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return properties;

	}

	@Override
	public BuildingDTO findById(Long id) {
		BuildingEntity buildingEntity = buildingRepository.findById(id);
		return buildingConverter.convertToDTO(buildingEntity);
	}

	@Override
	public BuildingDTO insert(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Date());
		buildingEntity.setCreatedBy("quyet dep trai");
		Long id = buildingRepository.insert(buildingEntity);
		return buildingConverter.convertToDTO(buildingRepository.findById(id));
	}

	@Override
	public BuildingDTO update(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setModifiedDate(new Date());
		buildingEntity.setModifiedBy("quyet dep trai part 2");
		Long isSuccess = buildingRepository.update(buildingEntity);
		if(isSuccess > 0) {
			return buildingConverter.convertToDTO(buildingRepository.findById(buildingDTO.getId()));
		}
		return new BuildingDTO();		
	}

	@Override
	public int delete(String[] idString) {
		return buildingRepository.delete(idString);
	}

	@Override
	public int countAll(BuildingSearchBuilder fieldSearch) {
		Map<String, Object> properties = convertToMapProperties(fieldSearch);
		return buildingRepository.countAll(properties, fieldSearch);
	}
}
