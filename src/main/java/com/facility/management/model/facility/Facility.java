package com.facility.management.model.facility;

import java.math.BigDecimal;

public interface Facility {

	Integer getFacilityId();

	void setFacilityId(Integer facilityId);

	FacilityAddress getFacilityAddress();

	void setFacilityAddress(FacilityAddress facilityAddress);

	String getFacilityName();

	void setFacilityName(String facilityName);

	Integer getCapacity();

	void setCapacity(Integer capacity);

	BigDecimal getTotalArea();

	void setTotalArea(BigDecimal totalArea);

	String getFacilityType();

	void setFacilityType(String facilityType);

}