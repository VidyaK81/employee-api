package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private Long employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(name = "employeeDepartment")
    private String employeeDepartment;

    @Column
    private Double employeeSalary;

    // Constructors
    public Employee() {}

    public Employee(String name, String department, Double salary) {
        this.employeeName = name;
        this.employeeDepartment = department;
        this.employeeSalary = salary;
    }

    // Getters and Setters
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long id) { this.employeeId = id; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getEmployeeDepartment() { return employeeDepartment; }
    public void setEmployeeDepartment(String employeeDepartment) { this.employeeDepartment = employeeDepartment; }

    public Double getEmployeeSalary() { return employeeSalary; }
    public void setEmployeeSalary(Double employeeSalary) { this.employeeSalary = employeeSalary; }
}
