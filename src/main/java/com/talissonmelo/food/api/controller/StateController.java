package com.talissonmelo.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.food.domain.model.State;
import com.talissonmelo.food.domain.model.repository.StateRepository;

@RestController
@RequestMapping(value = "/state")
public class StateController {

	@Autowired
	private StateRepository repository;
	
	@GetMapping
	public List<State> findAll(){
		return repository.findAll();
	}
}
