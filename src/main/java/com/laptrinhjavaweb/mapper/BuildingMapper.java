package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.dto.BuildingDTO;

public class BuildingMapper implements IGenericMapper<BuildingDTO> {

	@Override
	public BuildingDTO mapRow(ResultSet result) {
		BuildingDTO buildingDTO = new BuildingDTO();	
		try {
			buildingDTO.setId(result.getLong("id"));
			buildingDTO.setName(result.getString("name"));
			buildingDTO.setStreet(result.getString("street"));
			buildingDTO.setBuildingarea(result.getInt("buildingarea"));
			buildingDTO.setCarcost(result.getString("carcost"));
			buildingDTO.setCostdescription(result.getString("costdescription"));
			buildingDTO.setCostrent(result.getInt("costrent"));
			buildingDTO.setWard(result.getString("ward"));
			buildingDTO.setDeposit(result.getString("deposit"));
			buildingDTO.setDistrict(result.getString("district"));
			buildingDTO.setElectricitycost(result.getString("electricitycost"));
			buildingDTO.setManagername(result.getString("managername"));
			buildingDTO.setManagerphone(result.getString("managerphone"));
			buildingDTO.setType(result.getString("type"));
			buildingDTO.setTimerent(result.getString("timerent"));
			buildingDTO.setTimedecorator(result.getString("timedecorator"));
			buildingDTO.setStructure(result.getString("structure"));
			buildingDTO.setServicecost(result.getString("servicecost"));
			buildingDTO.setPayment(result.getString("payment"));
			buildingDTO.setOvertimecost(result.getString("overtimecost"));
			buildingDTO.setNumberOfBasement(result.getInt("numberOfBasement"));
			buildingDTO.setMotorbikecost(result.getString("motorbikecost"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildingDTO;
	}

}
