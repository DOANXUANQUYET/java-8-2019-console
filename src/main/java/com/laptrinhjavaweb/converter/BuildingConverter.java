package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;

public class BuildingConverter {
	
	public BuildingDTO convertToDTO(BuildingEntity buildingEntity) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingDTO dto = modelMapper.map(buildingEntity,BuildingDTO.class);
		dto.setBuildingTypes(buildingEntity.getType().split(","));
		dto.setAddress(dto.getStreet() + " , " + dto.getWard() + " , " + DistrictEnum.valueOfLabel(dto.getDistrict()).getValue());
		StringBuilder buildingTypesDiscription = new StringBuilder();
		for(String item : dto.getBuildingTypes()) {
			if(buildingTypesDiscription.length() > 1) {
				buildingTypesDiscription.append(",");
			}
			buildingTypesDiscription.append(BuildingTypesEnum.valueOfLabel(item).getValue());
		}
		dto.setBuildingTypesDiscription(buildingTypesDiscription.toString());
		return dto;
	}
	
	public BuildingEntity convertToEntity(BuildingDTO buildingDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(buildingDTO,BuildingEntity.class);
	}

}
