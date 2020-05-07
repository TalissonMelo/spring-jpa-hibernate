package com.talissonmelo.food.domain.model.repository;

import java.util.List;

import com.talissonmelo.food.domain.model.City;

public interface CityRepository {

	List<City> findAll();

	City findById(Long id);

	City save(City city);

	void deleteById(City city);
}
