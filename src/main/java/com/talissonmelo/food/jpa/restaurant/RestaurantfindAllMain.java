package com.talissonmelo.food.jpa.restaurant;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.Restaurant;
import com.talissonmelo.food.domain.model.repository.RestaurantRepository;

public class RestaurantfindAllMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestaurantRepository repository = applicationContext.getBean(RestaurantRepository.class);
			
		List<Restaurant> list = repository.findAll();
		
		for(Restaurant restaurant: list) {
			System.out.println("Restaurante: " + restaurant.getName() + ", Frete: " +restaurant.getShippingFee() + ", cozinha : " + restaurant.getKitchen().getName());
		}
	}

}
