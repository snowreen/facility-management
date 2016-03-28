package com.facility.management.model.facility;

import java.math.BigDecimal;

public class FacilityImpl implements Facility {
	
	private Integer facilityId;
	private FacilityAddress facilityAddress;
	private String facilityName;
	private Integer capacity;
	private BigDecimal totalArea;
	private String facilityType;

	public FacilityImpl() {
	}
	
	@Override
	public Integer getFacilityId() {
		return this.facilityId;
	}
	
	@Override
	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}
	
	@Override
	public FacilityAddress getFacilityAddress() {
		return this.facilityAddress;
	}
	
	@Override
	public void setFacilityAddress(FacilityAddress facilityAddress) {
		this.facilityAddress = facilityAddress;
	}
	
	@Override
	public String getFacilityName() {
		return this.facilityName;
	}
	
	@Override
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	
	@Override
	public Integer getCapacity() {
		return this.capacity;
	}
	
	@Override
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public BigDecimal getTotalArea() {
		return this.totalArea;
	}
	
	@Override
	public void setTotalArea(BigDecimal totalArea) {
		this.totalArea = totalArea;
	}
	
	@Override
	public String getFacilityType() {
		return this.facilityType;
	}
	
	@Override
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

}
