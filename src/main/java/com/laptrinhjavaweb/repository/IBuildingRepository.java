package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingRepository extends IGennericRepository<BuildingEntity> {
	List<BuildingEntity> findAll(Map<String, Object> params, int offset , int limit);
//	BuildingEntity findOne(Long id);
}
