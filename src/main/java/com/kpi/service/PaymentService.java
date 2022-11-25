package com.kpi.service;

import java.util.List;
import java.util.Optional;

import com.kpi.dto.PaymentSummaryDTO;

public interface PaymentService {
	
	List<PaymentSummaryDTO> getAllPayments(Optional<String> paymentDate);
	PaymentSummaryDTO createPaymentSummary(PaymentSummaryDTO paymentSummaryDTO);

}
