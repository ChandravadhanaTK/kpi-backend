package com.kpi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kpi.model.PaymentSummary;

@Repository
public interface PaymentSummaryRepository extends MongoRepository<PaymentSummary, String>{
}
