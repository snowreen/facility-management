package com.facility.management.model.facility;

public class Building extends Facility {

    private int buildingId;
    private int numOfFloors;
    private int noOfElevators;
    private int noOfEntrance;

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public int getNoOfElevators() {
        return noOfElevators;
    }

    public void setNoOfElevators(int noOfElevators) {
        this.noOfElevators = noOfElevators;
    }

    public int getNoOfEntrance() {
        return noOfEntrance;
    }

    public void setNoOfEntrance(int noOfEntrance) {
        this.noOfEntrance = noOfEntrance;
    }

    @Override
    public String toString() {
        return "Building{" +
                "facilityId=" + this.getFacilityId() +
                ", facilityName='" + this.getFacilityName() + '\'' +
                ", capacity=" + this.getCapacity() +
                ", totalArea=" + this.getTotalArea() +
                ", facilityType='" + this.getFacilityType() + '\'' +
                ", facilityAddress=" + this.getFacilityAddress() +
                ", buildingId=" + buildingId +
                ", numOfFloors=" + numOfFloors +
                ", noOfElevators=" + noOfElevators +
                ", noOfEntrance=" + noOfEntrance +
                '}';
    }
}
