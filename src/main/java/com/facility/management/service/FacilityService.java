package com.facility.management.service;

import com.facility.management.model.facility.Facility;

import java.util.List;

public interface FacilityService {

    public List<Facility> listFacilities();
    public Facility getFacilityInformation(int facilityId);
    public Long requestAvailableCapacity(int facilityId);
    public Boolean addNewFacility(Facility facility);
    public void addFacilityDetail(Facility facility);
    public Boolean removeFacility(int facilityId);
}
