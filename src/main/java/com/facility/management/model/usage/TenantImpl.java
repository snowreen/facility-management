package com.facility.management.model.usage;

public class TenantImpl implements Tenant {
	
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
	
	@Override
	public Integer getTenantId() {
		return this.tenantId;
	}
	
	@Override
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	
	@Override
	public String getFirstName() {
		return this.firstName;
	}
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String getLastName() {
		return this.lastName;
	}
	
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String getSsn() {
		return this.ssn;
	}
	
	@Override
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getPhone() {
		return this.phone;
	}
	
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String getAddress() {
		return this.address;
	}
	
	@Override
	public void setAddress(String address) {
		this.address = address;
	}

}
