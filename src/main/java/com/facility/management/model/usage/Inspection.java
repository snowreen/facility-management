package com.facility.management.model.usage;

import java.util.Date;

import com.facility.management.model.facility.Facility;

public interface Inspection {

	Integer getInspectionId();

	void setInspectionId(Integer inspectionId);

	Facility getFacility();

	void setFacility(Facility facility);

	Date getInspectionDate();

	void setInspectionDate(Date inspectionDate);

	String getInspectionResult();

	void setInspectionResult(String inspectionResult);

}