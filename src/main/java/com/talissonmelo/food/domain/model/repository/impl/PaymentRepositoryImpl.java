package com.talissonmelo.food.domain.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.talissonmelo.food.domain.model.Payment;
import com.talissonmelo.food.domain.model.repository.PaymentRepository;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Payment> findAll() {
		return manager.createQuery("from Payment", Payment.class).getResultList();
	}

	@Override
	public Payment findById(Long id) {
		return manager.find(Payment.class, id);
	}

	@Transactional
	@Override
	public Payment save(Payment payment) {
		return manager.merge(payment);
	}

	@Transactional
	@Override
	public void deleteById(Payment payment) {
		payment = findById(payment.getId());
		manager.remove(payment);
		
	}

}
