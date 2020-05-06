package com.talissonmelo.food.domain.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.talissonmelo.food.domain.model.Restaurant;
import com.talissonmelo.food.domain.model.repository.RestaurantRepository;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurant> findAll() {
		return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
	}

	@Override
	public Restaurant findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

}
