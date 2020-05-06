package com.talissonmelo.food.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.talissonmelo.food.domain.model.Kitchen;

@Component
public class KitchenJPA {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Kitchen> findAll(){
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
	}
}
