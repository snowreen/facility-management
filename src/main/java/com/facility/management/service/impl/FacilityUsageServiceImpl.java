package com.facility.management.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.facility.management.dal.FacilityUsageHibernateDAO;
import com.facility.management.model.usage.Inspection;
import com.facility.management.model.usage.LeaseInfo;
import com.facility.management.service.FacilityUsageService;

public class FacilityUsageServiceImpl implements FacilityUsageService {
	
	private FacilityUsageHibernateDAO facilityUsageDAO;

	public void setFacilityUsageDAO(FacilityUsageHibernateDAO facilityUsageDAO) {
		this.facilityUsageDAO = facilityUsageDAO;
	}

	@Override
	public Boolean isInUseDuringInterval(int facilityId, Date beginDate,
			Date endDate) {
		return facilityUsageDAO.isInUseDuringInterval(facilityId, beginDate, endDate);
	}

	@Override
	public Boolean assignFacilityToUse(LeaseInfo leaseInfo) {
		return facilityUsageDAO.assignFacilityToUse(leaseInfo);
	}

	@Override
	public Boolean vacateFacility(int facilityId, Date vacateDate) {
		return facilityUsageDAO.vacateFacility(facilityId, vacateDate);
	}

	@Override
	public List<Inspection> listInspections(int facilityId) {
		return facilityUsageDAO.getListOfInspections(facilityId);
	}

	@Override
	public Map<Integer, Long> listActualUsage() {
		return facilityUsageDAO.getListOfActualUsage();
	}

	@Override
	public Map<Integer, Double> calcUsageRate() {
		return facilityUsageDAO.getUsageRate();
	}
	
	
}
