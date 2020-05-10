package com.talissonmelo.food.domain.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.talissonmelo.food.domain.model.City;
import com.talissonmelo.food.domain.model.repository.CityRepository;

@Repository
public class CityRepositoryImpl implements CityRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public List<City> findAll() {
		return manager.createQuery("from City", City.class).getResultList();
	}

	@Override
	public City findById(Long id) {
		return manager.find(City.class, id);
	}

	@Transactional
	@Override
	public City save(City city) {
		return manager.merge(city);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		City city = findById(id);

		if (city == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(city);
	}

}
