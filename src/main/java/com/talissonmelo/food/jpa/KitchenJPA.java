package com.talissonmelo.food.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.talissonmelo.food.domain.model.Kitchen;

@Component
public class KitchenJPA {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Kitchen> findAll(){
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
	}
	
	public Kitchen findById(Long id) {
		return manager.find(Kitchen.class, id);
	}
	
	@Transactional
	public Kitchen add(Kitchen kitchen) {
		return manager.merge(kitchen);
	}
	
	@Transactional
	public void deleteById(Kitchen kitchen) {
		kitchen = findById(kitchen.getId());
		manager.remove(kitchen);
	}
}
