package com.facility.management.model.facility;

public interface BuildingUnit extends FacilityDetail {

	Integer getUnitId();

	void setUnitId(Integer unitId);

	Building getBuilding();

	void setBuilding(Building building);

	Facility getFacility();

	void setFacility(Facility facility);

	Integer getLevelNum();

	void setLevelNum(Integer levelNum);

	Integer getNumOfRooms();

	void setNumOfRooms(Integer numOfRooms);

}