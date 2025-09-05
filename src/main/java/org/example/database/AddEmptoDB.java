package org.example.database;

import org.example.config.PropertiesComponent;
import org.example.employeeapi.controller.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

@Component
public class AddEmptoDB {
    @Autowired
    private PropertiesComponent properties;

    public void addEmptoDB(EmployeeData employeeData) {
        String url = properties.getDatabaseUrl();//"jdbc:mysql://localhost:3306/sqlassdb";
        String user = properties.getDatabaseUser();//"myuser";
        String password = properties.getDatabasePsw();//"Myuser123";
        String sql = "Insert into Employee(EmployeeId,EmployeeName,EmployeeSalary,EmployeeDepartment) values (?,?,?,?)";
        // Use try-with-resources to auto-close Connection, Statement, and ResultSet
        try (
            Connection connection = getConnection(url, user, password);
            PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, employeeData.getEmployeeId());
            pstmt.setString(2, employeeData.getEmployeeName());
            pstmt.setDouble(3,employeeData.getEmployeeSalary());
            pstmt.setString(4,employeeData.getEmployeeDept());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");

        }   catch (SQLException e) {
            e.printStackTrace(); // More helpful than throwing RuntimeException blindly
        }
    }
}
