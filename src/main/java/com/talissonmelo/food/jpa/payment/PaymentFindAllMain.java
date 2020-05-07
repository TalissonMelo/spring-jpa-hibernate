package com.talissonmelo.food.jpa.payment;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.talissonmelo.food.AlgaFoodApiApplication;
import com.talissonmelo.food.domain.model.Payment;
import com.talissonmelo.food.domain.model.repository.PaymentRepository;

public class PaymentFindAllMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		PaymentRepository respository = applicationContext.getBean(PaymentRepository.class);

		List<Payment> list = respository.findAll();

		for (Payment payment : list) {
			System.out.println("Pagamento : " + payment.getDescription());
		}
	}
}
