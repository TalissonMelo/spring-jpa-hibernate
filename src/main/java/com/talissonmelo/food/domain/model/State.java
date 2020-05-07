package com.talissonmelo.food.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class State {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = true)
	private String name;
	
}
