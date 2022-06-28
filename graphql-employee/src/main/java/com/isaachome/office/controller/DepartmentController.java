package com.isaachome.office.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isaachome.office.model.Department;
import com.isaachome.office.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;

	@GetMapping("/all")
	public List<DepartmentResponse> getAllDepartments() {
		return departmentService.getAll();
	}

	@PostMapping("/add")
	public long addDepartment(@RequestParam String name) {
		Department department = new Department();
		department.setName(name);
		return departmentService.persist(department).getId();
	}
}
