package com.laptrinhjavaweb.enums;

public enum BuildingTypesEnum {
	
	TANG_TRET("Tầng trệt"),NGUYEN_CAN("Nguyên căn"),NOI_THAT("Nội thất"),ERROR("");
	
	private final String value;
	
	BuildingTypesEnum(String type) {
		this.value = type;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static BuildingTypesEnum valueOfLabel(String label) {
	    for (BuildingTypesEnum e : values()) {
	        if (e.name().equals(label)) {
	            return e;
	        }
	    }
	    return ERROR;
	}

}
