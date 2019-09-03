package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.entity.BuildingEntity;

public class BuildingMapper implements IGenericMapper<BuildingEntity> {

	@Override
	public BuildingEntity mapRow(ResultSet result) {
		BuildingEntity buildingEntity = new BuildingEntity();	
		try {
			buildingEntity.setId(result.getLong("id"));
			buildingEntity.setName(result.getString("name"));
			buildingEntity.setStreet(result.getString("street"));
			buildingEntity.setBuildingarea(result.getInt("buildingarea"));
			buildingEntity.setCarcost(result.getString("carcost"));
			buildingEntity.setCostdescription(result.getString("costdescription"));
			buildingEntity.setCostrent(result.getInt("costrent"));
			buildingEntity.setWard(result.getString("ward"));
			buildingEntity.setDeposit(result.getString("deposit"));
			buildingEntity.setDistrict(result.getString("district"));
			buildingEntity.setElectricitycost(result.getString("electricitycost"));
			buildingEntity.setManagername(result.getString("managername"));
			buildingEntity.setManagerphone(result.getString("managerphone"));
			buildingEntity.setType(result.getString("type"));
			buildingEntity.setTimerent(result.getString("timerent"));
			buildingEntity.setTimedecorator(result.getString("timedecorator"));
			buildingEntity.setStructure(result.getString("structure"));
			buildingEntity.setServicecost(result.getString("servicecost"));
			buildingEntity.setPayment(result.getString("payment"));
			buildingEntity.setOvertimecost(result.getString("overtimecost"));
			buildingEntity.setNumberOfBasement(result.getInt("numberOfBasement"));
			buildingEntity.setMotorbikecost(result.getString("motorbikecost"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildingEntity;
	}

}
