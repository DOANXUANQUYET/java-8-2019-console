package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.mapper.IGenericMapper;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends GenericRepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public List<BuildingEntity> query(String sql, IGenericMapper<BuildingEntity> rowMapper, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<BuildingEntity> findAll(Map<String, Object> properties,Pageable pageable) {
//		return this.findAll(properties,pageable);
//	}

}
