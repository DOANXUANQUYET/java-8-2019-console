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
		List<BuildingDTO> buildingsBuildingModels = buildingService.findAll();
		for (BuildingDTO building : buildingsBuildingModels) {
			System.out.println("Name : " + building.getName() + " - District : " + building.getDistrict() +
					"  - buildingarea : " + building.getBuildingArea() + " - street : " + building.getStreet());
		}

	}
}
