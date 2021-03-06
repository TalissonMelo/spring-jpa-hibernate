package com.talissonmelo.food.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.Restaurant;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;
import com.talissonmelo.food.domain.model.repository.RestaurantRepository;
import com.talissonmelo.food.domain.model.service.exception.EntityNotFoundException;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository repository;

	@Autowired
	private KitchenRepository kitchenRepository;

	public Restaurant insert(Restaurant restaurant) {
		Long kitchenId = restaurant.getKitchen().getId();
		Kitchen kitchen = kitchenRepository.findById(kitchenId)
				.orElseThrow(() -> new EntityNotFoundException("Cozinha não encontrada. ID: " + kitchenId));

		restaurant.setKitchen(kitchen);
		return repository.save(restaurant);
	}
}
