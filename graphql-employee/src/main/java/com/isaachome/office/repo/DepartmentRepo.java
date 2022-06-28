package com.isaachome.office.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.office.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
