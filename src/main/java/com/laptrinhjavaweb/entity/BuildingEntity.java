package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;

@Table(name = "building")
public class BuildingEntity {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "ward")
	private String ward;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "numberOfBasement")
	private Integer numberOfBasement;
	
	@Column(name = "buildingarea")
	private Integer buildingarea;
	
	@Column(name = "structure")
	private String structure;
	
	@Column(name = "costrent")
	private Integer costrent;
	
	@Column(name = "costdescription")
	private String costdescription;
	
	@Column(name = "servicecost")
	private String servicecost;
	
	@Column(name = "carcost")
	private String carcost;
	
	@Column(name = "motorbikecost")
	private String motorbikecost;
	
	@Column(name = "overtimecost")
	private String overtimecost;
	
	@Column(name = "electricitycost")
	private String electricitycost;
	
	@Column(name = "deposit")
	private String deposit;
	
	@Column(name = "payment")
	private String payment;
	
	@Column(name = "timerent")
	private String timerent;
	
	@Column(name = "timedecorator")
	private String timedecorator;
	
	@Column(name = "managername")
	private String managername;
	
	@Column(name = "managerphone")
	private String managerphone;
	
	@Column(name = "type")
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBuildingarea() {
		return buildingarea;
	}

	public void setBuildingarea(Integer buildingarea) {
		this.buildingarea = buildingarea;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getCostrent() {
		return costrent;
	}

	public void setCostrent(Integer costrent) {
		this.costrent = costrent;
	}

	public String getCostdescription() {
		return costdescription;
	}

	public void setCostdescription(String costdescription) {
		this.costdescription = costdescription;
	}

	public String getServicecost() {
		return servicecost;
	}

	public void setServicecost(String servicecost) {
		this.servicecost = servicecost;
	}

	public String getCarcost() {
		return carcost;
	}

	public void setCarcost(String carcost) {
		this.carcost = carcost;
	}

	public String getMotorbikecost() {
		return motorbikecost;
	}

	public void setMotorbikecost(String motorbikecost) {
		this.motorbikecost = motorbikecost;
	}

	public String getOvertimecost() {
		return overtimecost;
	}

	public void setOvertimecost(String overtimecost) {
		this.overtimecost = overtimecost;
	}

	public String getElectricitycost() {
		return electricitycost;
	}

	public void setElectricitycost(String electricitycost) {
		this.electricitycost = electricitycost;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getTimerent() {
		return timerent;
	}

	public void setTimerent(String timerent) {
		this.timerent = timerent;
	}

	public String getTimedecorator() {
		return timedecorator;
	}

	public void setTimedecorator(String timedecorator) {
		this.timedecorator = timedecorator;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagerphone() {
		return managerphone;
	}

	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

		

}
