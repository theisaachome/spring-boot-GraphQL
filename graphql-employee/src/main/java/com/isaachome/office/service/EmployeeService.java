package com.isaachome.office.service;
import java.util.List;

import com.isaachome.office.controller.EmployeeResponse;
import com.isaachome.office.model.Employee;

public interface EmployeeService {
	List<EmployeeResponse> getAll();

	Employee persist(Employee employee);
}
