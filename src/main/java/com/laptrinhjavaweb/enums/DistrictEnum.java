package com.laptrinhjavaweb.enums;

public enum DistrictEnum {

	QUAN_1("Quận 1"), QUAN_2("Quận 2"), QUAN_3("Quận 3"), QUAN_4("Quận 4"), QUAN_5("Quận 5"), QUAN_6("Quận 6"),ERROR("");

	private final String value;

	DistrictEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static DistrictEnum valueOfLabel(String label) {
	    for (DistrictEnum e : values()) {
	        if (e.name().equals(label)) {
	            return e;
	        }
	    }
	    return ERROR;
	}

}
