package com.talissonmelo.food.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;

@Service
public class KitchenService {

	@Autowired
	private KitchenRepository repository;
	
	public Kitchen insert(Kitchen kitchen) {
		return repository.save(kitchen);
	}
}
