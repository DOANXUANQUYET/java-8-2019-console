package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {
	private final String name; // required
	private final String district; // required
	private final String buildingArea;
	private final String numberOfBasement;
	private final String ward;
	private final String street;
	private String[] buildingTypes = new String[] {};
	private final String costRentFrom;
	private final String costRentTo;
	private final String areaRentFrom;
	private final String areaRentTo;
	private final String staffId;

	private BuildingSearchBuilder(Builder builder) {
		super();
		this.name = builder.name;
		this.district = builder.district;
		this.buildingArea = builder.buildingArea;
		this.numberOfBasement = builder.numberOfBasement;
		this.ward = builder.ward;
		this.street = builder.street;
		this.areaRentFrom = builder.areaRentFrom;
		this.areaRentTo = builder.areaRentTo;
		this.costRentFrom = builder.costRentFrom;
		this.costRentTo = builder.costRentTo;
		this.buildingTypes = builder.buildingTypes;
		this.staffId = builder.staffId;

	}

	public String getName() {
		return name;
	}

	public String getDistrict() {
		return district;
	}

	public String getBuildingArea() {
		return buildingArea;
	}

	public String getNumberOfBasement() {
		return numberOfBasement;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public String getCostRentFrom() {
		return costRentFrom;
	}

	public String getCostRentTo() {
		return costRentTo;
	}

	public String getAreaRentFrom() {
		return areaRentFrom;
	}

	public String getAreaRentTo() {
		return areaRentTo;
	}
	
	public String getStaffId() {
		return staffId;
	}

	// Builder class
	public static class Builder {

		private String name; // required
		private String district; // required
		private String buildingArea;
		private String numberOfBasement;
		private String ward;
		private String street;
		private String[] buildingTypes = new String[] {};
		private String costRentFrom;
		private String costRentTo;
		private String areaRentFrom;
		private String areaRentTo;
		private String staffId;
		
		public Builder(String name, String district) {
			this.name = name;
			this.district = district;
		}

		public Builder setBuildingArea(String buildingArea) {
			this.buildingArea = buildingArea;
			return this;
		}

		public Builder setNumberOfBasement(String numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setBuildingTypes(String[] buildingTypes) {
			this.buildingTypes = buildingTypes;
			return this;
		}

		public Builder setCostRentFrom(String costRentFrom) {
			this.costRentFrom = costRentFrom;
			return this;
		}

		public Builder setCostRentTo(String costRentTo) {
			this.costRentTo = costRentTo;
			return this;
		}

		public Builder setAreaRentFrom(String areaRentFrom) {
			this.areaRentFrom = areaRentFrom;
			return this;
		}

		public Builder setAreaRentTo(String areaRentTo) {
			this.areaRentTo = areaRentTo;
			return this;
		}
		
		public Builder setStaffId(String staffId) {
			this.staffId = staffId;
			return this;
		}

		public BuildingSearchBuilder build() {

			BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder(this);

			return buildingSearchBuilder;
		}

	}
}
