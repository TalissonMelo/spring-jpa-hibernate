package com.talissonmelo.food.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.food.api.controller.api.model.kitchenRepresentationXML;
import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;
import com.talissonmelo.food.domain.model.service.KitchenService;
import com.talissonmelo.food.domain.model.service.exception.EntityUsingException;

@RestController
@RequestMapping(value = "/kitchen") // , produces = MediaType.APPLICATION_XML_VALUE)
public class KitchenController {

	@Autowired
	private KitchenRepository repository;

	@Autowired
	private KitchenService service;

	@GetMapping
	public List<Kitchen> findAll() {
		return repository.findAll();
	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public kitchenRepresentationXML findAllXML() {
		return new kitchenRepresentationXML(repository.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Kitchen> findById(@PathVariable Long id) {
		Optional<Kitchen> kitchen = repository.findById(id);

		if (kitchen.isPresent()) {
			return ResponseEntity.ok().body(kitchen.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Kitchen insert(@RequestBody Kitchen kitchen) {
		return service.insert(kitchen);

		/*
		 * URI uri = ServletUriComponentsBuilder .fromCurrentRequest() .path("/{id}")
		 * .buildAndExpand(kitchen.getId()) .toUri(); return
		 * ResponseEntity.created(uri).body(kitchen);
		 */
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Kitchen> update(@PathVariable Long id, @RequestBody Kitchen kitchen) {
		Optional<Kitchen> kit = repository.findById(id);

		if (kit.isPresent()) {
			BeanUtils.copyProperties(kitchen, kit.get(), "id");
			Kitchen kitchenSave = service.insert(kit.get());
			return ResponseEntity.ok().body(kitchenSave);
		}

		return ResponseEntity.notFound().build();
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

	/*
	 * @GetMapping(value = "/names") public List<Kitchen>
	 * findByName(@RequestParam(value = "name") String name){ return
	 * repository.findByName(name); }
	 */
}
