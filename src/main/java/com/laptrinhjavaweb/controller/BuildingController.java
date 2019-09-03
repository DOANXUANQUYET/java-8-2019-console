package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {
	static private BuildingService buildingService = new BuildingService();

	public static void main(String[] args) {

//		BuildingDTO buildingModel = new BuildingDTO();
//		buildingModel.setName("Anh yeu em");
//		System.out.println(buildingModel.getName());
		List<BuildingEntity> buildingsBuildingModels = buildingService.findAll();
		for (BuildingEntity building : buildingsBuildingModels) {
			System.out.println("Name : " + building.getName() + " - District : " + building.getDistrict());
		}

	}
}
