package org.example.database;

import org.example.config.PropertiesComponent;
import org.example.employeeapi.controller.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeefromDB {


    private static final String SELECT_FROM_EMPLOYEE = "Select EmployeeId, EmployeeName, EmployeeSalary, " +
            "EmployeeDepartment from Employee";

    @Autowired
    private PropertiesComponent properties;

    public List<EmployeeData> getEmpDatafromDB() {

        String url = properties.getDatabaseUrl();//"jdbc:mysql://localhost:3306/sqlassdb";
        String user = properties.getDatabaseUser();//"myuser";
        String password = properties.getDatabasePsw();//"Myuser123";
        List<EmployeeData> dbEmpData = new ArrayList<>();

        // Use try-with-resources to auto-close Connection, Statement, and ResultSet
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_FROM_EMPLOYEE)
        )
        {// Process result set
            while (resultSet.next()) {
                int id = resultSet.getInt("EmployeeId");
                String name = resultSet.getString("EmployeeName");
                Double salary = resultSet.getDouble("EmployeeSalary");
                String department = resultSet.getString("EmployeeDepartment");
               // System.out.println("ID: " + id + ", Name: " + name +" , Salary: " + salary + ", Dept: " + department );
                    dbEmpData.add(new EmployeeData(id,name,salary,department));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // More helpful than throwing RuntimeException blindly
        }
        return dbEmpData;
    //for(EmployeeData data :dbEmpData){System.out.println(data.toString());
    //System.out.println(data.commaSeparatedString());}
    }
}
