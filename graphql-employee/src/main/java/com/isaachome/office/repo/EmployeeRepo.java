package com.isaachome.office.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.office.model.Employee;

public interface EmployeeRepo extends 
JpaRepository<Employee, Integer>{}
