package com.kpi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpi.dto.PaymentSummaryDTO;
import com.kpi.mapper.PaymentSummaryMapper;
import com.kpi.model.PaymentSummary;
import com.kpi.repositories.PaymentSummaryRepository;
import com.kpi.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentSummaryRepository paymentSummaryRepo;
	
	@Autowired
	private PaymentSummaryMapper paymentSummaryMapper;

	@Override
	public List<PaymentSummaryDTO> getAllPayments(Optional<String> paymentDate) {
		List<PaymentSummary> paymentSummaryList = new ArrayList<PaymentSummary>();
		if(paymentDate.isPresent()) {
			paymentSummaryList = paymentSummaryRepo.getPaymentSummaryBySelectedPaymentDate(paymentDate.get());
		}else {
			paymentSummaryList = paymentSummaryRepo.findAll();
		}
		List<PaymentSummaryDTO> paymentSummaryDTOList = null;
		if(paymentSummaryList != null && !paymentSummaryList.isEmpty()) {
			paymentSummaryDTOList = paymentSummaryMapper.mapPaymentSummaryModelToDto(paymentSummaryList);
		}
		return paymentSummaryDTOList;
	}
	
	@Override
	public PaymentSummaryDTO createPaymentSummary(PaymentSummaryDTO paymentSummaryDTO) {
		PaymentSummary paymentSummary = paymentSummaryMapper.mapDtoToPaymentSummaryModel(paymentSummaryDTO);
		paymentSummary = paymentSummaryRepo.save(paymentSummary);
		paymentSummaryDTO = paymentSummaryMapper.mapPaymentSummaryModelToDto(paymentSummary);
		return paymentSummaryDTO;
	}

	
}
 