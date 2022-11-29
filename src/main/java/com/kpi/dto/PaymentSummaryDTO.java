package com.kpi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSummaryDTO {
	private String id;
	private String paymentDate;
    private String country;        
    private Double totalCredit;
    private Double totalDebit;
    private Long noOfPayments;
    
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


