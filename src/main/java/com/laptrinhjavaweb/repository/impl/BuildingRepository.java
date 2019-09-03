package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.mapper.BuildingMapper;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends GenericRepository<BuildingEntity> implements IBuildingRepository  {

	@Override
	public List<BuildingEntity> findAll() {	
		List<BuildingEntity> listResult  = findAll(new BuildingMapper());
		return listResult;
	}

	@Override
	public BuildingEntity findOne(Long id) {
		String sql = "SELECT * FROM building WHERE id = ?";
		List<BuildingEntity> listResult = query(sql, new BuildingMapper(), id);
		return listResult.isEmpty() ? null : listResult.get(0);
	}

	
}
