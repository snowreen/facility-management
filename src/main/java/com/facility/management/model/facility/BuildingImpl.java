package com.facility.management.model.facility;

public class BuildingImpl implements Building {
	
	private Integer buildingId;
	private Facility facility;
	private Integer numOfElevators;
	private Integer numOfFloors;
	private Integer numOfEntrance;

	public BuildingImpl() {
	}
	
	@Override
	public Integer getBuildingId() {
		return this.buildingId;
	}
	
	@Override
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	
	@Override
	public Facility getFacility() {
		return this.facility;
	}
	
	@Override
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	@Override
	public Integer getNumOfElevators() {
		return this.numOfElevators;
	}
	
	@Override
	public void setNumOfElevators(Integer numOfElevators) {
		this.numOfElevators = numOfElevators;
	}
	
	@Override
	public Integer getNumOfFloors() {
		return this.numOfFloors;
	}
	
	@Override
	public void setNumOfFloors(Integer numOfFloors) {
		this.numOfFloors = numOfFloors;
	}
	
	@Override
	public Integer getNumOfEntrance() {
		return this.numOfEntrance;
	}
	
	@Override
	public void setNumOfEntrance(Integer numOfEntrance) {
		this.numOfEntrance = numOfEntrance;
	}

	@Override
	public String toString() {
		return "BuildingImpl [buildingId=" + buildingId + ", facility="
				+ facility.toString() + ", numOfElevators=" + numOfElevators
				+ ", numOfFloors=" + numOfFloors + ", numOfEntrance="
				+ numOfEntrance + "]";
	}

}
