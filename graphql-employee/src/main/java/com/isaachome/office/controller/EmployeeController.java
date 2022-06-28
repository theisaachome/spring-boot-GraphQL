package com.isaachome.office.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isaachome.office.model.Department;
import com.isaachome.office.model.Employee;
import com.isaachome.office.service.DepartmentService;
import com.isaachome.office.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	  private final EmployeeService employeeService;
	    private final DepartmentService departmentService;

	    @GetMapping("/all")
	    public List<EmployeeResponse> getAllEmployees() {
	        return employeeService.getAll();
	    }

	    @PostMapping("/add")
	    @Transactional
	    public long addEmployee(@RequestParam Long teamId, @RequestParam String name) {
	        Employee employee = new Employee();
	        employee.setName(name);

	        Employee savedEmployee = employeeService.persist(employee);

	        Department department = departmentService.find(teamId);
	        department.getEmployees().add(employee);
	        departmentService.persist(department);

	        return savedEmployee.getId();
	    }
}
