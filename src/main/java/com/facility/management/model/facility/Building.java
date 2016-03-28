package com.facility.management.model.facility;

public interface Building extends FacilityDetail {

	Integer getBuildingId();

	void setBuildingId(Integer buildingId);

	Facility getFacility();

	void setFacility(Facility facility);

	Integer getNumOfElevators();

	void setNumOfElevators(Integer numOfElevators);

	Integer getNumOfFloors();

	void setNumOfFloors(Integer numOfFloors);

	Integer getNumOfEntrance();

	void setNumOfEntrance(Integer numOfEntrance);

}