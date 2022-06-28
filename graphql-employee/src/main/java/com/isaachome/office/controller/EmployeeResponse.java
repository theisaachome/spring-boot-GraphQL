package com.isaachome.office.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.isaachome.office.model.Employee;

import lombok.Data;

@Data
public class EmployeeResponse {

	 private long id;
	    private String name;
	    private long departmentId;

	    public EmployeeResponse(Employee employee) {
	        this.id = employee.getId();
	        this.name = employee.getName();
	        this.departmentId = employee.getDepartment().getId();
	    }

	    public static List<EmployeeResponse> of(List<Employee> employees) {
	        return employees.stream()
	                .map(EmployeeResponse::new)
	                .collect(Collectors.toList());
	    }
}
