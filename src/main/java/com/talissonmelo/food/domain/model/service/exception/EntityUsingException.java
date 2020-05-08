package com.talissonmelo.food.domain.model.service.exception;

public class EntityUsingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityUsingException(String msg) {
		super(msg);
	}

}
