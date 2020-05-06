package com.talissonmelo.food.kitchen;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;

public class KitchenFindByIdMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		KitchenRepository repository = applicationContext.getBean(KitchenRepository.class);
	
		Kitchen kitchen = repository.findById(1l);
		
		System.out.println(kitchen.getName());
	}

}
