package com.talissonmelo.food.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.talissonmelo.food.domain.model.State;
import com.talissonmelo.food.domain.model.repository.StateRepository;
import com.talissonmelo.food.domain.model.service.exception.EntityNotFoundException;
import com.talissonmelo.food.domain.model.service.exception.EntityUsingException;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;

	public State insert(State state) {
		return repository.save(state);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Estado de ID: " + id + ",não encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new EntityUsingException("Entidade Estado em uso.");
		}
	}

}
