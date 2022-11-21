package com.kpi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpi.dto.PaymentSummaryDTO;
import com.kpi.model.PaymentSummary;

@Component
public class PaymentSummaryMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public List<PaymentSummaryDTO> mapPaymentSummaryModelToDto(List<PaymentSummary> paymentSummaryList){
		List<PaymentSummaryDTO> paymentSummaryDTOList = new ArrayList<PaymentSummaryDTO>();
		paymentSummaryList.stream().forEach(obj -> paymentSummaryDTOList.add(mapPaymentSummaryModelToDto(obj)));
		return paymentSummaryDTOList;
	}
	
	public PaymentSummaryDTO mapPaymentSummaryModelToDto(PaymentSummary paymentSummary) {
		return modelMapper.map(paymentSummary, PaymentSummaryDTO.class);
	}
	
	public List<PaymentSummary> mapDtoToPaymentSummaryModel(List<PaymentSummaryDTO> paymentSummaryDTOList){
		List<PaymentSummary> paymentSummaryList = new ArrayList<PaymentSummary>();
		paymentSummaryDTOList.stream().forEach(obj -> paymentSummaryList.add(mapDtoToPaymentSummaryModel(obj)));
		return paymentSummaryList;
	}
	
	public PaymentSummary mapDtoToPaymentSummaryModel(PaymentSummaryDTO paymentSummaryDTO){
		return modelMapper.map(paymentSummaryDTO, PaymentSummary.class);
	}
}
