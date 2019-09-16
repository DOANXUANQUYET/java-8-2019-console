package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {
	static private BuildingService buildingService = new BuildingService();

	public static void main(String[] args) {

		// user dien field tim kiem tren client
		int page = 1;
		int limit = 2;
		String name = "tower";
		String district = "QUAN_2";
		int buildingArea = 650;
		int numberOfBasement = 2;
		
		//map vao builder phan trang
		Pageable pageable = new PageRequest(page, limit);
		
		//map cac gia tri vao builder tao sqlwhere
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder(name, district)
				.setBuildingArea(buildingArea)
				.setNumberOfBasement(numberOfBasement)
				.build();
		
		//search buiding duoi DB
		List<BuildingDTO> buildingsBuildingModels = buildingService.findAll(buildingSearchBuilder,pageable);
		
		// output du lieu
		for (BuildingDTO building : buildingsBuildingModels) {
			System.out.println("id : "+ building.getId() + " - Name : " + building.getName() + " - District : " + building.getDistrict() +
					"  - buildingarea : " + building.getBuildingArea() + " - street : " + building.getStreet());
		}

	}
}
