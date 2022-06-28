package com.isaachome.office.service;
import java.util.List;

import com.isaachome.office.controller.DepartmentResponse;
import com.isaachome.office.model.Department;

public interface DepartmentService {

	List<DepartmentResponse> getAll();

	DepartmentResponse getById(Long id);

	Department find(Long id);

	Department persist(Department department);
}
