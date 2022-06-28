package com.isaachome.office.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isaachome.office.controller.EmployeeResponse;
import com.isaachome.office.model.Employee;
import com.isaachome.office.repo.EmployeeRepo;
import com.isaachome.office.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	  private final EmployeeRepo repo;
	   @Override
	    public List<EmployeeResponse> getAll() {
	        List<Employee> employees = repo.findAll();
	        return EmployeeResponse.of(employees);
	    }

	    @Override
	    public Employee persist(Employee employee) {
	        return repo.save(employee);
	    }

}
