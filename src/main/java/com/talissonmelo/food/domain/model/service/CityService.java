package com.talissonmelo.food.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.talissonmelo.food.domain.model.City;
import com.talissonmelo.food.domain.model.State;
import com.talissonmelo.food.domain.model.repository.CityRepository;
import com.talissonmelo.food.domain.model.repository.StateRepository;
import com.talissonmelo.food.domain.model.service.exception.EntityNotFoundException;
import com.talissonmelo.food.domain.model.service.exception.EntityUsingException;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	@Autowired
	private StateRepository stateRepository;
	
	public City insert(City city) {
		Long stateId = city.getState().getId();
		State state = stateRepository.findById(stateId);
	
		if(state == null) {
			throw new EntityNotFoundException("Estado de ID: " + stateId + ", não encontrado.");
		}
		
		city.setState(state);
		return repository.save(city);
	}
	
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Cidade de ID:" + id + ", nao encontrada.");
		}catch (DataIntegrityViolationException e) {
			throw new EntityUsingException("Cidade de ID: " + id + ", não pode ser deletada.");
		}
	}
}
