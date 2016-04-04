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

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getLeaseId()
	 */
	@Override
	public Integer getLeaseId() {
		return this.leaseId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setLeaseId(java.lang.Integer)
	 */
	@Override
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getFacility()
	 */
	@Override
	public Facility getFacility() {
		return this.facility;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setFacility(com.facility.management.model.Facility)
	 */
	@Override
	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getTenant()
	 */
	@Override
	public Tenant getTenant() {
		return this.tenant;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setTenant(com.facility.management.model.TenantImpl)
	 */
	@Override
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getStartDate()
	 */
	@Override
	public Date getStartDate() {
		return this.startDate;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setStartDate(java.util.Date)
	 */
	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getEndDate()
	 */
	@Override
	public Date getEndDate() {
		return this.endDate;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setEndDate(java.util.Date)
	 */
	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getSecurityDeposite()
	 */
	@Override
	public BigDecimal getSecurityDeposite() {
		return this.securityDeposite;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setSecurityDeposite(java.math.BigDecimal)
	 */
	@Override
	public void setSecurityDeposite(BigDecimal securityDeposite) {
		this.securityDeposite = securityDeposite;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getTerminationDate()
	 */
	@Override
	public Date getTerminationDate() {
		return this.terminationDate;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setTerminationDate(java.util.Date)
	 */
	@Override
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#getStatus()
	 */
	@Override
	public String getStatus() {
		return this.status;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.LeaseInfo#setStatus(java.lang.String)
	 */
	@Override
	public void setStatus(String status) {
		this.status = status;
	}

}
