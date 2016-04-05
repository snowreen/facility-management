package com.facility.management.model.usage;

import java.math.BigDecimal;
import java.util.Date;

import com.facility.management.model.facility.Facility;

public class PurchaseInfoImpl implements PurchaseInfo {

	private Integer purchaseId;
	private Facility facility;
	private Owner owner;
	private Date purchaseDate;
	private BigDecimal puchasePrice;

	public PurchaseInfoImpl() {
	}

	public PurchaseInfoImpl(Facility facility, Owner owner, Date purchaseDate,
			BigDecimal puchasePrice) {
		this.facility = facility;
		this.owner = owner;
		this.purchaseDate = purchaseDate;
		this.puchasePrice = puchasePrice;
	}
	
	@Override
	public Integer getPurchaseId() {
		return this.purchaseId;
	}
	
	@Override
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
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
	public Owner getOwner() {
		return this.owner;
	}
	
	@Override
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	@Override
	public Date getPurchaseDate() {
		return this.purchaseDate;
	}
	
	@Override
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@Override
	public BigDecimal getPuchasePrice() {
		return this.puchasePrice;
	}
	
	@Override
	public void setPuchasePrice(BigDecimal puchasePrice) {
		this.puchasePrice = puchasePrice;
	}

}
