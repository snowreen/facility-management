package com.facility.management.service;

import java.util.List;

import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityDetail;

public interface FacilityService {
	
	public FacilityDetail getFacilityInformation(int facilityId);
    public void addFacilityDetail(FacilityDetail facility);
    public void addNewFacility(Facility facility);
    public void removeFacility(Facility facility);
    public List<Facility> listFacilities();
    public Integer requestAvailableCapacity(int facilityId);
}
