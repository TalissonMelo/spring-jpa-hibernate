package com.talissonmelo.food.jpa.permission;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.Permission;
import com.talissonmelo.food.domain.model.repository.PermissionRepository;

public class PermissionFindAllMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

	PermissionRepository respository = applicationContext.getBean(PermissionRepository.class);

		List<Permission> list = respository.findAll();

		for(Permission permission : list){
			System.out.println("Permissões : " + permission.getDescription() + ", " + permission.getName());
		}

	}

}
