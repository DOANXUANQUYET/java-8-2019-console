package com.laptrinhjavaweb.view;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class Client {
	
	static IBuildingService buidingService = new BuildingService();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Long id = 3L;
		
		BuildingEntity bd = buidingService.findOne(id);
		
		System.out.println("id : " + bd.getId());
		System.out.println("name : "  + bd.getName());
		System.out.println("buildingarea : " + bd.getBuildingarea());
		System.out.println("district : " + bd.getDistrict());
		System.out.println("ward : " + bd.getWard());
		System.out.println("street : " + bd.getStreet());
		System.out.println("cost discription : " + bd.getCostdescription());
		

	}

}
