//package org.example;
//
//import org.example.employeeapi.controller.Employee;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmpNameTest
//{
//    List<Employee> employees = new ArrayList<>();
//    public static void main(String[] args) {
//        EmpNameTest obj = new EmpNameTest();
//        Employee e1 = new Employee(101,"name1","manager1");
//        obj.addEmployee(e1);
//    }
//
//
//    public void addEmployee(Employee employee)
//    {
//        if (employee == null || employee.getName()==null || employee.getName().isEmpty()) {
//            throw new RuntimeException("Name is mandatory!");
//        }
//        Boolean addStatus = employees.add(employee);
//        System.out.println("Employee added successfully." + employees.size());
//
//
//    }
//
//    public void addEmployee2(String name)
//    {
//
//        System.out.println("Employee added successfully." + employees.size());
//
//
//    }
//}
