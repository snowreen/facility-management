package com.facility.management.model.usage;

import java.math.BigDecimal;
import java.util.Date;

import com.facility.management.model.facility.Facility;

public interface LeaseInfo {

	Integer getLeaseId();

	void setLeaseId(Integer leaseId);

	Facility getFacility();

	void setFacility(Facility facility);

	Tenant getTenant();

	void setTenant(Tenant tenant);

	Date getStartDate();

	void setStartDate(Date startDate);

	Date getEndDate();

	void setEndDate(Date endDate);

	BigDecimal getSecurityDeposite();

	void setSecurityDeposite(BigDecimal securityDeposite);

	Date getTerminationDate();

	void setTerminationDate(Date terminationDate);

	String getStatus();

	void setStatus(String status);

}