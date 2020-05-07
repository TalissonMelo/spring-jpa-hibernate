package com.talissonmelo.food.domain.model.repository;

import java.util.List;

import com.talissonmelo.food.domain.model.Permission;

public interface PermissionRepository {
	
	List<Permission> findAll();

	Permission findById(Long id);

	Permission save(Permission permission);

	void deleteById(Permission permission);

}
