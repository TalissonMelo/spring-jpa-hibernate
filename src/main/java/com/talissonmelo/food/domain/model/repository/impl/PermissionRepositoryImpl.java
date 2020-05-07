package com.talissonmelo.food.domain.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.talissonmelo.food.domain.model.Permission;
import com.talissonmelo.food.domain.model.repository.PermissionRepository;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Permission> findAll() {
		return manager.createQuery("from Permission", Permission.class).getResultList();
	}

	@Override
	public Permission findById(Long id) {
		return manager.find(Permission.class, id);
	}

	@Transactional
	@Override
	public Permission save(Permission permission) {
		return manager.merge(permission);
	}

	@Transactional
	@Override
	public void deleteById(Permission permission) {
		permission = findById(permission.getId());
		manager.remove(permission);

	}

}
