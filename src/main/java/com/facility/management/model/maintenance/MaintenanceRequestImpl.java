package com.facility.management.model.maintenance;

import java.util.Date;

import com.facility.management.model.facility.Facility;


public class MaintenanceRequestImpl implements MaintenanceRequest {
	
	private Integer mainReqId;
	private Facility facility;
	private Date requestDate;
	private String nameOfRequester;
	private String detail;
	private String email;
	private String subject;

	public MaintenanceRequestImpl() {
	}

	public MaintenanceRequestImpl(Facility facility, Date requestDate,
			String nameOfRequester, String detail, String email, String subject) {
		this.facility = facility;
		this.requestDate = requestDate;
		this.nameOfRequester = nameOfRequester;
		this.detail = detail;
		this.email = email;
		this.subject = subject;
	}
	
	@Override
	public Integer getMainReqId() {
		return this.mainReqId;
	}
	
	@Override
	public void setMainReqId(Integer mainReqId) {
		this.mainReqId = mainReqId;
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
	public Date getRequestDate() {
		return this.requestDate;
	}
	
	@Override
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	@Override
	public String getNameOfRequester() {
		return this.nameOfRequester;
	}
	
	@Override
	public void setNameOfRequester(String nameOfRequester) {
		this.nameOfRequester = nameOfRequester;
	}
	
	@Override
	public String getDetail() {
		return this.detail;
	}
	
	@Override
	public void setDetail(String detail) {
		this.detail = detail;
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
	public String getSubject() {
		return this.subject;
	}
	
	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "MaintenanceRequestImpl [mainReqId=" + mainReqId + ", facilityId="
				+ facility.getFacilityId() + ", requestDate=" + requestDate
				+ ", nameOfRequester=" + nameOfRequester + ", detail=" + detail
				+ ", email=" + email + ", subject=" + subject + "]";
	}
	
	

}
