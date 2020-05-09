package com.talissonmelo.food.domain.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.talissonmelo.food.domain.model.State;
import com.talissonmelo.food.domain.model.repository.StateRepository;

@Component
public class StateRepositoryImpl implements StateRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public List<State> findAll() {
		return manager.createQuery("from State", State.class).getResultList();
	}

	@Override
	public State findById(Long id) {
		return manager.find(State.class, id);
	}

	@Override
	@Transactional
	public State save(State state) {
		return manager.merge(state);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		State state = findById(id);

		if (state == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(state);
	}

}
