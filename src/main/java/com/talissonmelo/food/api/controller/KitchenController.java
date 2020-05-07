package com.talissonmelo.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.food.api.controller.api.model.kitchenRepresentationXML;
import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;

@RestController
@RequestMapping(value = "/kitchen") // , produces = MediaType.APPLICATION_XML_VALUE)
public class KitchenController {

	@Autowired
	private KitchenRepository repository;

	@GetMapping
	public List<Kitchen> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public kitchenRepresentationXML findAllXML() {
		return new kitchenRepresentationXML(repository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public Kitchen findById(@PathVariable Long id) {
		return repository.findById(id);
	}

}
