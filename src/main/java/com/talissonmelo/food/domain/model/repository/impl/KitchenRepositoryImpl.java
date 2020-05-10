package com.talissonmelo.food.domain.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;

@Repository
public class KitchenRepositoryImpl implements KitchenRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Kitchen> findAll() {
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
	}

	@Override
	public Kitchen findById(Long id) {
		return manager.find(Kitchen.class, id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		Kitchen kitchen = findById(id);

		if (kitchen == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(kitchen);
	}

	@Override
	@Transactional
	public Kitchen save(Kitchen kitchen) {
		return manager.merge(kitchen);

	}

	@Override
	public List<Kitchen> findByName(String name) {
		return manager.createQuery("from Kitchen where name like :name", Kitchen.class)
			.setParameter("name", "%" + name + "%")
			.getResultList();
	}
}
