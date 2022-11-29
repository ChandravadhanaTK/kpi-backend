package com.kpi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("paymentsummary")
public class PaymentSummary {
	@Id
	private String id;
	private String paymentDate;
    private String country;
    private Double totalCredit;
    private Double totalDebit;
    private Long noOfPayments;

    public PaymentSummary() {}

    public PaymentSummary(String id, String paymentDate, String country, Double totalCredit, Double totalDebit, Long noOfPayments) {
    	this.id = id;
    	this.paymentDate = paymentDate;
        this.country = country;
        this.totalCredit = totalCredit;
        this.totalDebit = totalDebit;
        this.noOfPayments = noOfPayments;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}

	public Double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(Double totalDebit) {
		this.totalDebit = totalDebit;
	}

	public Long getNoOfPayments() {
		return noOfPayments;
	}

	public void setNoOfPayments(Long noOfPayments) {
		this.noOfPayments = noOfPayments;
	}
    
}
