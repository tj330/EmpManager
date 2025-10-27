package com.tj330.empmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String salary;

    public Employee() {
    }

    @Override
    public String toString() {
        // Assuming you have getters for these fields
        return String.format("\nEmployee[ID=%d,\n Name=%s,\n Email=%s,\n  Salary=%s]\n",
                getId(),
                getName(),
                getEmail(),
                getSalary()
        );
    }

    public Employee(Long id, String name, String email, String salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
