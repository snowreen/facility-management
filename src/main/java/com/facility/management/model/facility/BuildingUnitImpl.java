package com.facility.management.model.facility;

public class BuildingUnitImpl implements BuildingUnit {
	
	private Integer unitId;
	private Building building;
	private Facility facility;
	private Integer levelNum;
	private Integer numOfRooms;

	public BuildingUnitImpl() {
	}
	
	@Override
	public Integer getUnitId() {
		return this.unitId;
	}
	
	@Override
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	
	@Override
	public Building getBuilding() {
		return this.building;
	}
	
	@Override
	public void setBuilding(Building building) {
		this.building = building;
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
	public Integer getLevelNum() {
		return this.levelNum;
	}
	
	@Override
	public void setLevelNum(Integer levelNum) {
		this.levelNum = levelNum;
	}
	
	@Override
	public Integer getNumOfRooms() {
		return this.numOfRooms;
	}
	
	@Override
	public void setNumOfRooms(Integer numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

	@Override
	public String toString() {
		return "BuildingUnitImpl [unitId=" + unitId + ", building=" + building.toString()
				+ ", levelNum=" + levelNum
				+ ", numOfRooms=" + numOfRooms + "]";
	}

}
