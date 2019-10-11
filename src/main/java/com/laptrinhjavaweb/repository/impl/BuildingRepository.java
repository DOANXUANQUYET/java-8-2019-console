package com.laptrinhjavaweb.repository.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends GenericRepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> properties,Pageable pageable,BuildingSearchBuilder fieldSearch) {
		StringBuilder sqlSearch = new StringBuilder("SELECT * FROM building A ");
		if(fieldSearch.getStaffId() != null) {
			sqlSearch.append("INNER JOIN assignmentstaff assignstaff ON A.id = assignstaff.buildingid ");
		}
		sqlSearch.append("WHERE 1 = 1 ");
		sqlSearch = this.createSQLfindAll(properties, sqlSearch);
		sqlSearch.append(buildSqlSpecial(fieldSearch));
		return this.findAll(sqlSearch.toString(),pageable);
	}
	
	//tao  nhung phan search dac thu cua buildingSerach
	private String buildSqlSpecial(BuildingSearchBuilder fieldSearch) {
		StringBuilder result = new StringBuilder("");
		if (StringUtils.isNotBlank(fieldSearch.getCostRentFrom())) {
			result.append(" AND A.costrent >= " + fieldSearch.getCostRentFrom() + "");
		}
		if (StringUtils.isNotBlank(fieldSearch.getCostRentTo())) {
			result.append(" AND A.costrent <= " + fieldSearch.getCostRentTo() + "");
		}
		if (fieldSearch.getBuildingTypes().length > 0 && StringUtils.isNotBlank(fieldSearch.getBuildingTypes()[0])) {
			result.append(" AND ( ");
			// ----------------------------java 7 -----------------------------------
			/*
			 * int index = 0; for (String item : fieldSearch.getBuildingTypes()) { if (index
			 * == 0) { result.append("A.type like '% " + item + "%'"); }else {
			 * result.append(" OR A.type like '% " + item + "%'"); } index++; }
			 */

			// ------------------------------java 8 --------------------------------
			result.append("A.type like '%" + fieldSearch.getBuildingTypes()[0] + "%'");
			Arrays.stream(fieldSearch.getBuildingTypes())
					.filter(item -> !item.equals(fieldSearch.getBuildingTypes()[0]))
					.forEach(item -> result.append(" OR A.type like '%" + item + "%'"));
			result.append(")");

		}
		if (StringUtils.isNotBlank(fieldSearch.getAreaRentFrom()) || StringUtils.isNotBlank(fieldSearch.getAreaRentTo())) {
			result.append(" AND EXISTS ( SELECT * FROM rentarea ra WHERE (ra.buildingid = A.id ");
			if(fieldSearch.getAreaRentFrom() != null) {			
				result.append(" AND ra.value >= " + fieldSearch.getAreaRentFrom() + "");
			}
			if(fieldSearch.getAreaRentTo() != null) {				
				result.append(" AND ra.value <= " + fieldSearch.getAreaRentTo() + "");
			}
			result.append(" ))");
		}
		if(StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			result.append(" AND staffid = " + fieldSearch.getStaffId() + "");
		}
		return result.toString();
	}

}
