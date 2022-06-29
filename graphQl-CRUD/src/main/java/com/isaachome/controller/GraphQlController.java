package com.isaachome.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.isaachome.service.CoffeeService;
import com.isaachome.model.Coffee;
import com.isaachome.model.Size;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GraphQlController {

	private final CoffeeService service;
	
	@MutationMapping
	public Coffee createCoffee(@Argument String name ,@Argument Size size) {
		return service.create(name,size);
	}
	@MutationMapping
	public Coffee deleteCoffee(@Argument long id) {
		return service.deleteCoffee(id);
	}
	@MutationMapping
	public Coffee updateCoffee(@Argument long id,
			@Argument String name,
			@Argument Size size) {
		return service.updateCoffee(id, name, size);
	}
	@QueryMapping
	public List<Coffee> allCoffee(){
		return service.findAllCoffee();
	}
	
	@QueryMapping
	public Coffee getCoffee(@Argument long id) {
		return service.getById(id);
	}
	
}
