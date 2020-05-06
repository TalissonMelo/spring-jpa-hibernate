package com.talissonmelo.food.domain.model.repository;

import java.util.List;

import com.talissonmelo.food.domain.model.Restaurant;

public interface RestaurantRepository {

	List<Restaurant> findAll();

	Restaurant findById(Long id);

	Restaurant save(Restaurant restaurant);

	void deleteById(Restaurant restaurant);
}
