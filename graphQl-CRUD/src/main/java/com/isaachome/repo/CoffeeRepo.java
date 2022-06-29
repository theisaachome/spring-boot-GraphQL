package com.isaachome.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.model.Coffee;

public interface CoffeeRepo extends JpaRepository<Coffee, Long> {

}
