package com.talissonmelo.food.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.talissonmelo.food.domain.model.City;
import com.talissonmelo.food.domain.model.repository.CityRepository;
import com.talissonmelo.food.domain.model.service.CityService;
import com.talissonmelo.food.domain.model.service.exception.EntityNotFoundException;
import com.talissonmelo.food.domain.model.service.exception.EntityUsingException;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

	@Autowired
	private CityRepository repository;

	@Autowired
	private CityService service;

	@GetMapping
	public ResponseEntity<List<City>> findAll() {
		List<City> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		City city = repository.findById(id);

		if (city == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(city);
	}

	@PostMapping
	public ResponseEntity<City> insert(@RequestBody City city) {
		city = service.insert(city);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(city.getId()).toUri();
		return ResponseEntity.created(uri).body(city);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (EntityUsingException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody City city) {
		try {
			City cityUpdate = repository.findById(id);

			if (cityUpdate != null) {
				BeanUtils.copyProperties(city, cityUpdate, "id");
				cityUpdate = service.insert(cityUpdate);
				return ResponseEntity.ok().body(cityUpdate);
			}

			return ResponseEntity.notFound().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
