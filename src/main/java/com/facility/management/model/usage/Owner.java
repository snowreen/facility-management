package com.facility.management.model.usage;

public interface Owner {

	Integer getOwnerId();

	void setOwnerId(Integer ownerId);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	String getSsn();

	void setSsn(String ssn);

	String getEmail();

	void setEmail(String email);

	String getPhone();

	void setPhone(String phone);

	String getAddress();

	void setAddress(String address);

}