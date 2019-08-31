package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.mapper.BuildingMapper;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends GenericRepository<BuildingDTO> implements IBuildingRepository  {

	@Override
	public List<BuildingDTO> findAll() {	
		String sql = "SELECT * FROM building";
		List<BuildingDTO> listResult  = query(sql,new BuildingMapper());
		return listResult;
	}

	@Override
	public BuildingDTO findOne(Long id) {
		String sql = "SELECT * FROM building WHERE id = ?";
		List<BuildingDTO> listResult = query(sql, new BuildingMapper(), id);
		return listResult.isEmpty() ? null : listResult.get(0);
	}

	
}
