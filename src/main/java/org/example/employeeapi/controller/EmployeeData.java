package org.example.employeeapi.controller;

//Table = Employee

public class EmployeeData {


    //Column
    private int employeeId;
    //Column
    private String employeeName;
    private double employeeSalary;
    private String employeeDept;

    public EmployeeData(int employeeId, String employeeName, double employeeSalary, String employeeDept) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDept = employeeDept;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public String toString(){

        return "EmployeeData{EmployeeId=" + employeeId +
                " : " + "EmployeeName=" + employeeName +
                " : " + "EmployeeSalary=" + employeeSalary +
                " : " + "EmployeeDept=" + employeeDept + "}";
    }
    public  String commaSeparatedString(){
        return  employeeId + "," + employeeName + "," + employeeSalary + "," + employeeDept;
    }
}

