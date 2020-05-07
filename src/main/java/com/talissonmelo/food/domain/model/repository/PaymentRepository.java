package com.talissonmelo.food.domain.model.repository;

import java.util.List;

import com.talissonmelo.food.domain.model.Payment;

public interface PaymentRepository {
	
	List<Payment> findAll();

	Payment findById(Long id);

	Payment save(Payment payment);

	void deleteById(Payment payment);

}
