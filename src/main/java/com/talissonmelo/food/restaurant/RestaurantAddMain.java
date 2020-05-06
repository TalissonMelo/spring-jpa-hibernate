package com.talissonmelo.food.restaurant;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.Restaurant;
import com.talissonmelo.food.domain.model.repository.RestaurantRepository;

public class RestaurantAddMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestaurantRepository repository = applicationContext.getBean(RestaurantRepository.class);
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Casa de Vó");
		
		repository.save(restaurant);
		
		
	}

}
