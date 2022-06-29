package com.isaachome.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isaachome.model.Coffee;
import com.isaachome.model.Size;
import com.isaachome.repo.CoffeeRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeService {

	private final CoffeeRepo repo;
	
	public Coffee create(String name,Size size ) {
		var newCoffee = new Coffee();
		newCoffee.setName(name);
		newCoffee.setSize(size);
		return repo.save(newCoffee);
	}
	
	public List<Coffee> findAllCoffee(){
		return repo.findAll();
	}
	
	public Coffee getById(long id) {
		return repo.findById(id).orElseThrow(
				()-> new IllegalStateException("No Coffe Found with ID " + id ));
	}
	public Coffee updateCoffee(long id,String name,Size size) {
		var coffee = repo.findById(id).orElseThrow(
				()-> new IllegalStateException("No Coffe Found with ID " + id ));
		coffee.setName(name);
		coffee.setSize(size);
		return repo.save(coffee);
		 	
	}
	
	public Coffee deleteCoffee (long id) {
		var coffee = repo.findById(id).orElseThrow(
				()-> new IllegalStateException("No Coffe Found with ID " + id ));
		repo.delete(coffee);
		return coffee;
	}
	
}
