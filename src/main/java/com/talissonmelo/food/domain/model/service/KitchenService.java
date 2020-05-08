package com.talissonmelo.food.domain.model.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;
import com.talissonmelo.food.domain.model.service.exception.EntityUsingException;

@Service
public class KitchenService {

	@Autowired
	private KitchenRepository repository;

	public Kitchen insert(Kitchen kitchen) {
		return repository.save(kitchen);
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntityUsingException("Cozinha de ID: " + id + ", não pode ser removida.");
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Cozinha de ID : " + id + ", não encontrada.");
		}
	}
}
