package com.facility.management.model.maintenance;

import java.util.Date;

import com.facility.management.model.facility.Facility;

public interface MaintenanceRequest {

	Integer getMainReqId();

	void setMainReqId(Integer mainReqId);

	Facility getFacility();

	void setFacility(Facility facility);

	Date getRequestDate();

	void setRequestDate(Date requestDate);

	String getNameOfRequester();

	void setNameOfRequester(String nameOfRequester);

	String getDetail();

	void setDetail(String detail);

	String getEmail();

	void setEmail(String email);

	String getSubject();

	void setSubject(String subject);

}