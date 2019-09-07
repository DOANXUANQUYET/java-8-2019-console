package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.entity.BuildingEntity;

public class BuildingMapperVersion1 implements IGenericMapperVersion1<BuildingEntity> {

	@Override
	public BuildingEntity mapRow(ResultSet result) {
		BuildingEntity buildingEntity = new BuildingEntity();	
		try {
			buildingEntity.setId(result.getLong("id"));
			buildingEntity.setName(result.getString("name"));
			buildingEntity.setStreet(result.getString("street"));
			buildingEntity.setBuildingArea(result.getInt("buildingarea"));
			buildingEntity.setCarCost(result.getString("carcost"));
			buildingEntity.setCostDescription(result.getString("costdescription"));
			buildingEntity.setCostRent(result.getInt("costrent"));
			buildingEntity.setWard(result.getString("ward"));
			buildingEntity.setDeposit(result.getString("deposit"));
			buildingEntity.setDistrict(result.getString("district"));
			buildingEntity.setElectricityCost(result.getString("electricitycost"));
			buildingEntity.setManagerName(result.getString("managername"));
			buildingEntity.setManagerPhone(result.getString("managerphone"));
			buildingEntity.setType(result.getString("type"));
			buildingEntity.setTimeRent(result.getString("timerent"));
			buildingEntity.setTimeDecorator(result.getString("timedecorator"));
			buildingEntity.setStructure(result.getString("structure"));
			buildingEntity.setServiceCost(result.getString("servicecost"));
			buildingEntity.setPayment(result.getString("payment"));
			buildingEntity.setOvertimeCost(result.getString("overtimecost"));
			buildingEntity.setNumberOfBasement(result.getInt("numberOfBasement"));
			buildingEntity.setMotorbikeCost(result.getString("motorbikecost"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildingEntity;
	}

}
