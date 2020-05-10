package com.talissonmelo.food.domain.model.repository;

import java.util.List;

import com.talissonmelo.food.domain.model.Kitchen;

public interface KitchenRepository {

	List<Kitchen> findAll();
	
	List<Kitchen> findByName(String name);

	Kitchen findById(Long id);

	Kitchen save(Kitchen kitchen);

	void deleteById(Long id);
}
