package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;

import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.service.ILoadDataCommonService;

public class LoadDataComonService implements ILoadDataCommonService {

	@Override
	public HashMap<String, String> loadDistrict() {
		HashMap<String, String> result = new HashMap<String, String>();
		for(DistrictEnum item : DistrictEnum.values()) {
			if(item != DistrictEnum.ERROR) {
				result.put(item.toString(), item.getValue());
			}	
		}
		return result;
	}

	@Override
	public HashMap<String, String> loadBuildingTypes() {
		HashMap<String, String> result = new HashMap<String, String>();
		for(BuildingTypesEnum item : BuildingTypesEnum.values()) {
			if(item != BuildingTypesEnum.ERROR) {
				result.put(item.toString(), item.getValue());
			}
		}
		return result;
	}
	

}
