package org.example.employeeapi.controller;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Sibling of @Component, @Service and @Controller
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        List<Employee> findByEmployeeName(String name);



    // Native SQL query (uses DB column names)
        @Query(value = "SELECT * FROM Employee WHERE EmployeeName = :name AND EmployeeID = :id", nativeQuery = true)
        List<Employee> findByNameAndIDNative(@Param("name") String name, @Param("id") int id);



}
