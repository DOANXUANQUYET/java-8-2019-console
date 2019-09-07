package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.mapper.BuildingMapperVersion1;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.IBuildingRepositoryVersion1;

public class BuildingRepositoryVersion1 extends GenericRepositoryVersion1<BuildingEntity> implements IBuildingRepositoryVersion1  {

	@Override
	public List<BuildingEntity> findAll() {	
		String sql = "SELECT * FROM building";
		List<BuildingEntity> listResult  = query(sql,new BuildingMapperVersion1());
		return listResult;
	}

	@Override
	public BuildingEntity findOne(Long id) {
		String sql = "SELECT * FROM building WHERE id = ?";
		List<BuildingEntity> listResult = query(sql, new BuildingMapperVersion1(), id);
		return listResult.isEmpty() ? null : listResult.get(0);
	}


	
}
