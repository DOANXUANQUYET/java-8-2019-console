package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingService {
	List<BuildingEntity> findAll();
	BuildingEntity findOne(Long id);
}
