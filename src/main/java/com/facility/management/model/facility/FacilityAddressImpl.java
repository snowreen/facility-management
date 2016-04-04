package com.facility.management.model.facility;

import java.util.Set;

public class FacilityAddressImpl implements FacilityAddress {
	
	private Integer facilityAddressId;
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private Set<Facility> facilities;

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
	public Set<Facility> getFacilities() {
		return facilities;
	}
	
	@Override
	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	@Override
	public String toString() {
		return "FacilityAddressImpl [facilityAddressId=" + facilityAddressId
				+ ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	

}
