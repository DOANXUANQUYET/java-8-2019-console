package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {
	static private BuildingService buildingService = new BuildingService();

	public static void main(String[] args) {

//		BuildingDTO buildingModel = new BuildingDTO();
//		buildingModel.setName("Anh yeu em");
//		System.out.println(buildingModel.getName());
		int page = 1;
		int limit = 2;
		int offset = (page - 1) * limit;
//		String name = "tower";
//		String district = "QUAN_2";
//		int buildingArea = 650;
//		int numberOfBasement = 2;
		List<BuildingDTO> buildingsBuildingModels = buildingService.findAll(offset,limit);
		for (BuildingDTO building : buildingsBuildingModels) {
			System.out.println("id : "+ building.getId() + " - Name : " + building.getName() + " - District : " + building.getDistrict() +
					"  - buildingarea : " + building.getBuildingArea() + " - street : " + building.getStreet());
		}

	}
}
