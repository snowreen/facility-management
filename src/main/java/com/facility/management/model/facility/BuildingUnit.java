package com.facility.management.model.facility;

public class BuildingUnit extends Facility {

    private int unitId;
    private int buildingId;
    private int levelNum;
    private int numOfRooms;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Override
    public String toString() {
        return "BuildingUnit{" +
                "facilityId=" + this.getFacilityId() +
                ", facilityName='" + this.getFacilityName() + '\'' +
                ", capacity=" + this.getCapacity() +
                ", totalArea=" + this.getTotalArea() +
                ", facilityType='" + this.getFacilityType() + '\'' +
                ", facilityAddress=" + this.getFacilityAddress() +
                ", unitId=" + unitId +
                ", buildingId=" + buildingId +
                ", levelNum=" + levelNum +
                ", numOfRooms=" + numOfRooms +
                '}';
    }
}
