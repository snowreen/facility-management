package com.facility.management.model.facility;

import java.util.List;

public class FacilityAddressImpl implements FacilityAddress {
	
	private Integer facilityAddressId;
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private List<Facility> facilities;

	public FacilityAddressImpl() {
	}

	public FacilityAddressImpl(String streetAddress, String city, String state,
			String zipcode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	@Override
	public Integer getFacilityAddressId() {
		return this.facilityAddressId;
	}
	
	@Override
	public void setFacilityAddressId(Integer facilityAddressId) {
		this.facilityAddressId = facilityAddressId;
	}
	
	@Override
	public String getStreetAddress() {
		return this.streetAddress;
	}
	
	@Override
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Override
	public String getCity() {
		return this.city;
	}
	
	@Override
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String getState() {
		return this.state;
	}
	
	@Override
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String getZipcode() {
		return this.zipcode;
	}
	
	@Override
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public List<Facility> getFacilities() {
		return facilities;
	}
	
	@Override
	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

}
