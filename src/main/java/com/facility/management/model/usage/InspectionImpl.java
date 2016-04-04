package com.facility.management.model.usage;

import java.util.Date;

import com.facility.management.model.facility.Facility;

public class InspectionImpl implements Inspection {
	
	private Integer inspectionId;
	private Facility facility;
	private Date inspectionDate;
	private String inspectionResult;

	public InspectionImpl() {
	}
	
	@Override
	public Integer getInspectionId() {
		return this.inspectionId;
	}
	
	@Override
	public void setInspectionId(Integer inspectionId) {
		this.inspectionId = inspectionId;
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
	public Date getInspectionDate() {
		return this.inspectionDate;
	}
	
	@Override
	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	
	@Override
	public String getInspectionResult() {
		return this.inspectionResult;
	}
	
	@Override
	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	@Override
	public String toString() {
		return "InspectionImpl [inspectionId=" + inspectionId + ", inspectionDate=" + inspectionDate
				+ ", inspectionResult=" + inspectionResult + "]";
	}

}
