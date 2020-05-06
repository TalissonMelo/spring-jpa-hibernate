package com.talissonmelo.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.Kitchen;

public class KitchenAddMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		KitchenJPA jpa = applicationContext.getBean(KitchenJPA.class);
		
		Kitchen kitchen = new Kitchen();
		kitchen.setName("Brasileira");
		
		Kitchen kitchen1 = new Kitchen();
		kitchen1.setName("Japonesa");
		
		jpa.add(kitchen1);
		jpa.add(kitchen);
	}

}
