package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.mapper.IGenericMapper;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends GenericRepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public List<BuildingEntity> query(String sql, IGenericMapper<BuildingEntity> rowMapper,
			Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, int offset, int limit) {
		String name = (String) params.get("name");
		String district = (String) params.get("district");
		int buildingArea = (int) params.get("buildingArea");
		int numberOfBasement = (int) params.get("numberOfBasement");
		StringBuilder where = new StringBuilder(" AND A.name LIKE '%" + name + "%' AND A.district LIKE '%" + district + "%'");
		where.append(" AND A.buildingarea = " + buildingArea + " AND A.numberofbasement = " + numberOfBasement + "");
		return this.findAll(offset, limit, where.toString());
	}

}
