package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {
	private final String name; // required
	private final String district; // required
	private final int buildingArea;
	private final int numberOfBasement;

	private BuildingSearchBuilder(Builder builder) {
		super();
		this.name = builder.name;
		this.district = builder.district;
		this.buildingArea = builder.buildingArea;
		this.numberOfBasement = builder.numberOfBasement;

	}

	public String getName() {
		return name;
	}

	public String getDistrict() {
		return district;
	}

	public int getBuildingArea() {
		return buildingArea;
	}

	public int getNumberOfBasement() {
		return numberOfBasement;
	}

	// Builder class
	public static class Builder {

		private String name; // required
		private String district; // required
		private int buildingArea;
		private int numberOfBasement;

		public Builder(String name, String district) {
			this.name = name;
			this.district = district;
		}

		public Builder setBuildingArea(int buildingArea) {
			this.buildingArea = buildingArea;
			return this;
		}

		public Builder setNumberOfBasement(int numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public BuildingSearchBuilder build() {

			BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder(this);

			return buildingSearchBuilder;
		}

	}
}
