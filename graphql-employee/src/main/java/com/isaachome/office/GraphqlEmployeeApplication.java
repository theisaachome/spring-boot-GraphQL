package com.isaachome.office;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.isaachome.office.model.Department;
import com.isaachome.office.model.Employee;
import com.isaachome.office.service.DepartmentService;
import com.isaachome.office.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class GraphqlEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlEmployeeApplication.class, args);
	}

}



@Component
@Profile("!test")
@RequiredArgsConstructor
class Initializr implements CommandLineRunner {

	private final DepartmentService departmentService;
	private final EmployeeService employeeService;

	@Override
	public void run(String... args) {
		Department savedDepartment = departmentService.persist(new Department("DevOps"));
		List<Employee> employees = Arrays.asList(new Employee("Sam", savedDepartment),
				new Employee("John", savedDepartment), new Employee("Ayush", savedDepartment));
		for (Employee e : employees) {
			employeeService.persist(e);
			savedDepartment.getEmployees().add(e);
		}
		departmentService.persist(savedDepartment);
	}
}
