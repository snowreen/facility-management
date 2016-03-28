package com.facility.management.model.usage;

import java.math.BigDecimal;
import java.util.Date;

import com.facility.management.model.facility.Facility;

public interface PurchaseInfo {

	Integer getPurchaseId();

	void setPurchaseId(Integer purchaseId);

	Facility getFacility();

	void setFacility(Facility facility);

	Owner getOwner();

	void setOwner(Owner owner);

	Date getPurchaseDate();

	void setPurchaseDate(Date purchaseDate);

	BigDecimal getPuchasePrice();

	void setPuchasePrice(BigDecimal puchasePrice);

}