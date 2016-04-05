package com.facility.management.model.usage;

public class OwnerImpl implements Owner {

	private Integer ownerId;
	private String firstName;
	private String lastName;
	private String ssn;
	private String email;
	private String phone;
	private String address;

	public OwnerImpl() {
	}

	public OwnerImpl(String firstName, String lastName, String ssn, String email,
			String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	@Override
	public Integer getOwnerId() {
		return this.ownerId;
	}
	
	@Override
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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
