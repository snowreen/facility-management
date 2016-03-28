package com.facility.management.model.facility;

import java.util.List;

public interface FacilityAddress {

	Integer getFacilityAddressId();

	void setFacilityAddressId(Integer facilityAddressId);

	String getStreetAddress();

	void setStreetAddress(String streetAddress);

	String getCity();

	void setCity(String city);

	String getState();

	void setState(String state);

	String getZipcode();

	void setZipcode(String zipcode);
	
	List<Facility> getFacilities();
	
	void setFacilities(List<Facility> facilities);

}