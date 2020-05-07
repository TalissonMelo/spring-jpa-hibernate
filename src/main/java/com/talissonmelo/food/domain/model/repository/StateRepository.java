package com.talissonmelo.food.domain.model.repository;

import java.util.List;

import com.talissonmelo.food.domain.model.State;

public interface StateRepository {

	List<State> findAll();

	State findById(Long id);

	State save(State state);

	void deleteById(State state);
}
