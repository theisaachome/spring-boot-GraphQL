package com.isaachome.office.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Department {


    public Department(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "DEPARTMENT_ID")
    private long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "DEPARTMENT_ID")
    private List<Employee> employees = new ArrayList<>();
}
