package com.kpi.service;

import java.util.List;

import com.kpi.dto.PaymentSummaryDTO;

public interface PaymentService {
	
	List<PaymentSummaryDTO> getAllPayments();
	PaymentSummaryDTO createPaymentSummary(PaymentSummaryDTO paymentSummaryDTO);

}
