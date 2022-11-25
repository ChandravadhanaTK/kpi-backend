package com.kpi.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kpi.model.PaymentSummary;

@Repository
public interface PaymentSummaryRepository extends MongoRepository<PaymentSummary, String>{
	
	@Query("{paymentDate: ?0}")
	List<PaymentSummary> getPaymentSummaryBySelectedPaymentDate(String paymentDate);
}
