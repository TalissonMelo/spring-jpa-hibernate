package com.talissonmelo.food.jpa.kitchen;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.Kitchen;
import com.talissonmelo.food.domain.model.repository.KitchenRepository;

public class KitchenAddMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		KitchenRepository repository = applicationContext.getBean(KitchenRepository.class);
		
		Kitchen kitchen = new Kitchen();
		kitchen.setName("Brasileira");
		
		Kitchen kitchen1 = new Kitchen();
		kitchen1.setName("Japonesa");
		
		repository.save(kitchen1);
		repository.save(kitchen);
	}

}
