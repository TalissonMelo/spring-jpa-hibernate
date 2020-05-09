package com.talissonmelo.food.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talissonmelo.food.domain.model.Restaurant;
import com.talissonmelo.food.domain.model.repository.RestaurantRepository;
import com.talissonmelo.food.domain.model.service.RestaurantService;
import com.talissonmelo.food.domain.model.service.exception.EntityNotFoundException;

@Controller
@RequestMapping(value = "/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository repository;

	@Autowired
	private RestaurantService service;

	@GetMapping
	public ResponseEntity<List<Restaurant>> findAll() {
		List<Restaurant> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Restaurant> findById(@PathVariable Long id) {
		Restaurant restaurant = repository.findById(id);

		if (restaurant != null) {
			return ResponseEntity.ok().body(restaurant);
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Restaurant restaurant) {
		try {
			Restaurant rest = service.insert(restaurant);
			return ResponseEntity.status(HttpStatus.CREATED).body(rest);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
		try {
			Restaurant restaurantUpdate = repository.findById(id);

			if (restaurantUpdate != null) {
				BeanUtils.copyProperties(restaurant, restaurantUpdate, "id");

				restaurantUpdate = service.insert(restaurantUpdate);
				return ResponseEntity.ok().body(restaurantUpdate);
			}

			return ResponseEntity.notFound().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
