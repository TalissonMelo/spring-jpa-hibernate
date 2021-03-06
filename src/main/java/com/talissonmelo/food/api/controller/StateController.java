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

import com.talissonmelo.food.domain.model.State;
import com.talissonmelo.food.domain.model.repository.StateRepository;
import com.talissonmelo.food.domain.model.service.StateService;
import com.talissonmelo.food.domain.model.service.exception.EntityNotFoundException;
import com.talissonmelo.food.domain.model.service.exception.EntityUsingException;

@RestController
@RequestMapping(value = "/states")
public class StateController {

	@Autowired
	private StateRepository repository;

	@Autowired
	private StateService service;

	@GetMapping
	public ResponseEntity<List<State>> findAll() {
		List<State> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<State> findById(@PathVariable Long id) {
		State state = repository.findById(id);

		if (state == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(state);
	}

	@PostMapping
	public ResponseEntity<State> insert(@RequestBody State state) {
		state = service.insert(state);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(state.getId()).toUri();
		return ResponseEntity.created(uri).body(state);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<State> update(@PathVariable Long id, @RequestBody State state) {
		State stateUpdate = repository.findById(id);

		if (stateUpdate != null) {
			BeanUtils.copyProperties(state, stateUpdate, "id");
			stateUpdate = service.insert(stateUpdate);
			return ResponseEntity.ok().body(stateUpdate);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (EntityUsingException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

}
