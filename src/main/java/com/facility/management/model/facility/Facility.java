package com.facility.management.model.facility;

public class Facility {

    private int facilityId;
    private String facilityName;
    private long capacity;
    private double totalArea;
    private String facilityType;
    private FacilityAddress facilityAddress;

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public FacilityAddress getFacilityAddress() {
        return facilityAddress;
    }

    public void setFacilityAddress(FacilityAddress facilityAddress) {
        this.facilityAddress = facilityAddress;
    }

    @Override
    public String toString() {
        return "Facility {" +
                "facilityId=" + facilityId +
                ", facilityName='" + facilityName + '\'' +
                ", capacity=" + capacity +
                ", totalArea=" + totalArea +
                ", facilityType='" + facilityType + '\'' +
                ", facilityAddress=" + facilityAddress +
                '}';
    }
}
