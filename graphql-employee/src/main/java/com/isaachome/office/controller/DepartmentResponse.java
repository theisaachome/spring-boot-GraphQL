package com.isaachome.office.controller;

import java.util.List;

import com.isaachome.office.model.Department;

import lombok.Data;

@Data
public class DepartmentResponse {

	 private long id;
	    private String name;
	    private List<EmployeeResponse> employees;

	    public DepartmentResponse(Department department) {
	        this.id = department.getId();
	        this.name = department.getName();
	        this.setEmployees(EmployeeResponse.of(department.getEmployees()));
	    }
}
