package com.facility.management.model.usage;
// Generated Mar 14, 2016 11:20:33 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Tenant generated by hbm2java
 */
public class TenantImpl implements java.io.Serializable, Tenant {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3818355421601506888L;
	private Integer tenantId;
	private String firstName;
	private String lastName;
	private String ssn;
	private String email;
	private String phone;
	private String address;

	public TenantImpl() {
	}

	public TenantImpl(String firstName, String lastName, String ssn, String email,
			String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#getTenantId()
	 */
	@Override
	public Integer getTenantId() {
		return this.tenantId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#setTenantId(java.lang.Integer)
	 */
	@Override
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return this.firstName;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#getLastName()
	 */
	@Override
	public String getLastName() {
		return this.lastName;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#getSsn()
	 */
	@Override
	public String getSsn() {
		return this.ssn;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#setSsn(java.lang.String)
	 */
	@Override
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#getEmail()
	 */
	@Override
	public String getEmail() {
		return this.email;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#getPhone()
	 */
	@Override
	public String getPhone() {
		return this.phone;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#setPhone(java.lang.String)
	 */
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#getAddress()
	 */
	@Override
	public String getAddress() {
		return this.address;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Tenant#setAddress(java.lang.String)
	 */
	@Override
	public void setAddress(String address) {
		this.address = address;
	}

}