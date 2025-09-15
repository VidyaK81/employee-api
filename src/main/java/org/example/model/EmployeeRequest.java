package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class EmployeeRequest {



    private String employeeName;

    private String employeeDepartment;

    private Double employeeSalary;


    public EmployeeRequest(String name, String department, Double salary) {
        this.employeeName = name;
        this.employeeDepartment = department;
        this.employeeSalary = salary;
    }


    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getEmployeeDepartment() { return employeeDepartment; }
    public void setEmployeeDepartment(String employeeDepartment) { this.employeeDepartment = employeeDepartment; }

    public Double getEmployeeSalary() { return employeeSalary; }
    public void setEmployeeSalary(Double employeeSalary) { this.employeeSalary = employeeSalary; }
}
