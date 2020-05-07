package com.talissonmelo.food.api.controller.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.talissonmelo.food.domain.model.Kitchen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "kitchens")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class kitchenRepresentationXML {

	@JsonProperty(value = "kitchen")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Kitchen> kitchens;
}
