package com.talissonmelo.food.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.food.domain.model.Kitchen;

public interface KitchenRepository extends JpaRepository<Kitchen, Long>{	
//	List<Kitchen> findByName(String name);

}
