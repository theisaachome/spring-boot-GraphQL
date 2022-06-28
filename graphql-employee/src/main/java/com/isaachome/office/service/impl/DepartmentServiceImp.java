package com.isaachome.office.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.isaachome.office.controller.DepartmentResponse;
import com.isaachome.office.model.Department;
import com.isaachome.office.repo.DepartmentRepo;
import com.isaachome.office.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

	private final DepartmentRepo repo;

	@Override
	public List<DepartmentResponse> getAll() {
		List<Department> departments = repo.findAll();

		return departments.stream().map(DepartmentResponse::new).collect(Collectors.toList());
	}

	@Override
	public DepartmentResponse getById(Long id) {
		Department department = repo.findById(id).get();
		return new DepartmentResponse(department);
	}

	@Override
	public Department find(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Department persist(Department department) {
		return repo.save(department);
	}

}
