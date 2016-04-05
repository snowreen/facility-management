package com.facility.management.model.usage;

import java.math.BigDecimal;
import java.util.Date;

import com.facility.management.model.facility.Facility;


public class LeaseInfoImpl implements LeaseInfo {

	private Integer leaseId;
	private Facility facility;
	private Tenant tenant;
	private Date startDate;
	private Date endDate;
	private BigDecimal securityDeposite;
	private Date terminationDate;
	private String status;

	public LeaseInfoImpl() {
	}

	public LeaseInfoImpl(Facility facility, Tenant tenant, Date startDate,
			Date endDate, BigDecimal securityDeposite, Date terminationDate,
			String status) {
		this.facility = facility;
		this.tenant = tenant;
		this.startDate = startDate;
		this.endDate = endDate;
		this.securityDeposite = securityDeposite;
		this.terminationDate = terminationDate;
		this.status = status;
	}
	
	@Override
	public Integer getLeaseId() {
		return this.leaseId;
	}
	
	@Override
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}
	
	@Override
	public Facility getFacility() {
		return this.facility;
	}
	
	@Override
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	@Override
	public Tenant getTenant() {
		return this.tenant;
	}
	
	@Override
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	@Override
	public Date getStartDate() {
		return this.startDate;
	}
	
	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public Date getEndDate() {
		return this.endDate;
	}
	
	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public BigDecimal getSecurityDeposite() {
		return this.securityDeposite;
	}
	
	@Override
	public void setSecurityDeposite(BigDecimal securityDeposite) {
		this.securityDeposite = securityDeposite;
	}
	
	@Override
	public Date getTerminationDate() {
		return this.terminationDate;
	}
	
	@Override
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	
	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

}
