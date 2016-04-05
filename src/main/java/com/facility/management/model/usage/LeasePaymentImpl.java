package com.facility.management.model.usage;


import java.math.BigDecimal;
import java.util.Date;

public class LeasePaymentImpl implements LeasePayment {
	
	private Integer paymentId;
	private LeaseInfo leaseInfo;
	private BigDecimal amountDue;
	private Date paymentDate;
	private BigDecimal amountPaid;
	private Date dueDate;

	public LeasePaymentImpl() {
	}

	public LeasePaymentImpl(LeaseInfo leaseInfo, BigDecimal amountDue,
			Date paymentDate, BigDecimal amountPaid, Date dueDate) {
		this.leaseInfo = leaseInfo;
		this.amountDue = amountDue;
		this.paymentDate = paymentDate;
		this.amountPaid = amountPaid;
		this.dueDate = dueDate;
	}

	@Override
	public Integer getPaymentId() {
		return this.paymentId;
	}
	
	@Override
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	
	@Override
	public LeaseInfo getLeaseInfo() {
		return this.leaseInfo;
	}
	
	@Override
	public void setLeaseInfo(LeaseInfo leaseInfo) {
		this.leaseInfo = leaseInfo;
	}
	
	@Override
	public BigDecimal getAmountDue() {
		return this.amountDue;
	}
	
	@Override
	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	
	@Override
	public Date getPaymentDate() {
		return this.paymentDate;
	}
	
	@Override
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	@Override
	public BigDecimal getAmountPaid() {
		return this.amountPaid;
	}
	
	@Override
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	@Override
	public Date getDueDate() {
		return this.dueDate;
	}
	
	@Override
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
