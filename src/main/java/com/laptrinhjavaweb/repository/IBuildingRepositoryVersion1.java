package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingRepositoryVersion1 extends IGennericRepositoryVersion1<BuildingEntity> {
	List<BuildingEntity> findAll();
	BuildingEntity findOne(Long id);
}
