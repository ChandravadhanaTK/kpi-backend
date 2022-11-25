package com.kpi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.kpi.dto.PaymentSummaryDTO;
import com.kpi.exception.RequestInvalidException;
import com.kpi.exception.RequestNotFoundException;
import com.kpi.service.PaymentService;

@Controller
public class PaymentController {
	
	@Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentSummaryDTO>> getAllPayments(@RequestParam("paymentDate") Optional<String> paymentDate) {
    	Optional<List<PaymentSummaryDTO>> paymentSummaryDtoList = Optional.ofNullable(paymentService.getAllPayments(paymentDate));
    	if(paymentSummaryDtoList.isPresent()) {
    		return ResponseEntity.ok(paymentSummaryDtoList.get());
    	}else {
    		throw new RequestNotFoundException("Payment summary details are not found in database.");
    	}
    }

    @PostMapping("/payments")
    public ResponseEntity<PaymentSummaryDTO> createPayment(@RequestBody PaymentSummaryDTO paymentSummaryDTO) {
    	try {
    		PaymentSummaryDTO savedDTO = paymentService.createPaymentSummary(paymentSummaryDTO);
        	return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO);
    	}catch(IllegalArgumentException ex) {
    		throw new RequestInvalidException("Payment summary POST request is invalid. Please check the request.");
    	}
    }
	 
}
