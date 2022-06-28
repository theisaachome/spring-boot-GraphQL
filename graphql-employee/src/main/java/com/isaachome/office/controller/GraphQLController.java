package com.isaachome.office.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.isaachome.office.model.Department;
import com.isaachome.office.service.DepartmentService;
import com.isaachome.office.service.EmployeeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GraphQLController {

	private final DepartmentService departmentService;
	private final EmployeeService employeeService;
	
	@QueryMapping
	public List<EmployeeResponse> employees(){
		return employeeService.getAll();
	}
	
	@QueryMapping
	public List<DepartmentResponse> departments(){
		return departmentService.getAll();
	}
	

    @QueryMapping
    public DepartmentResponse departmentById(@Argument long id) {
        return departmentService.getById(id);
    }

    @MutationMapping
    public DepartmentResponse updateDepartmentName(@Argument("id") long id, @Argument("name") String name) {
        Department department = departmentService.find(id);
        department.setName(name);
        Department updated = departmentService.persist(department);
        return new DepartmentResponse(updated);
    }
}
