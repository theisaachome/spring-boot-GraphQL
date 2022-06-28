package com.isaachome.office.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {

	   @Id
	    @GeneratedValue
	    private long id;
	    private String name;

	    @ManyToOne
	    @JoinColumn(name = "DEPARTMENT_ID", insertable = false, updatable = false)
	    private Department department;
	    
	    public Employee(String name, Department department) {
	        this.name = name;
	        this.department = department;
	    }

	}