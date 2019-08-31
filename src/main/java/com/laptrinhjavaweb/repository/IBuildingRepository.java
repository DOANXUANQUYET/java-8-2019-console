package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingRepository extends IGennericRepository<BuildingDTO> {
	List<BuildingDTO> findAll();
	BuildingDTO findOne(Long id);
}
