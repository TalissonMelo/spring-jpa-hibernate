package com.talissonmelo.food.jpa.city;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.City;
import com.talissonmelo.food.domain.model.repository.CityRepository;

public class CityFindAllMain {

	public static void main(String[] args) {
		
		 ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
                 .web(WebApplicationType.NONE)
                 .run(args);
         
         CityRepository cidadeRepository = applicationContext.getBean(CityRepository.class);
         
         List<City> cities = cidadeRepository.findAll();
         
         for (City city : cities) {
        	 System.out.println("Cidade: " + city.getName() 
        	 					+ ", Estado : " + city.getState().getName());
         }

	}

}
