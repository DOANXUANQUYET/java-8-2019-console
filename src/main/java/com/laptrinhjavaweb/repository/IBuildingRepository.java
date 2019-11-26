package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;

public interface IBuildingRepository extends IGennericRepository<BuildingEntity> {
	List<BuildingEntity> findAll(Map<String, Object> properties, Pageable pageable,BuildingSearchBuilder fieldSearch);
//	BuildingEntity findOne(Long id);
	int countAll(Map<String, Object> properties,BuildingSearchBuilder fieldSearch);
}
