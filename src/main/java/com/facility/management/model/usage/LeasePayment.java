package com.facility.management.model.usage;

import java.math.BigDecimal;
import java.util.Date;

public interface LeasePayment {

	Integer getPaymentId();

	void setPaymentId(Integer paymentId);

	LeaseInfo getLeaseInfo();

	void setLeaseInfo(LeaseInfo leaseInfo);

	BigDecimal getAmountDue();

	void setAmountDue(BigDecimal amountDue);

	Date getPaymentDate();

	void setPaymentDate(Date paymentDate);

	BigDecimal getAmountPaid();

	void setAmountPaid(BigDecimal amountPaid);

	Date getDueDate();

	void setDueDate(Date dueDate);

}