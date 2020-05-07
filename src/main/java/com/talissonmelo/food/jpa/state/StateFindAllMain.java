package com.talissonmelo.food.jpa.state;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.State;
import com.talissonmelo.food.domain.model.repository.StateRepository;

public class StateFindAllMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		StateRepository respository = applicationContext.getBean(StateRepository.class);

		List<State> list = respository.findAll();

		for(State state : list){
			System.out.println("Estado : " + state.getName());
		}
	}
}
