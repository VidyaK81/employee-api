package org.example.employeeapi.controller;
import org.example.config.PropertiesComponent;
import org.example.database.AddEmptoDB;
import org.example.database.EmployeefromDB;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    List<EmployeeData> employees = new ArrayList<>();

    @Autowired
    private PropertiesComponent properties;
    @Autowired
    private EmployeeService objEmployeeService;
    @Autowired
    private EmployeefromDB employeefromDB;
    @Autowired
    private AddEmptoDB objaddEmptoDB;
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/buildEmployeeList")
    public List<EmployeeData> getAllEmployees() {
        System.out.println("In get request");
        String fileName = properties.getFileName();
        System.out.println("File name is ::" + fileName);
       //EmployeeService objEmployeeService = new EmployeeService();
       List<EmployeeData> employees1 = objEmployeeService.buildEmployeeList(fileName);
        employees1.addAll(employees);
       return employees1;
    }

    @GetMapping("/Employees")
    public List<EmployeeData> getAllEmployeesDB() {
        System.out.println("In getDB request");
        List<EmployeeData> employeesDB = employeefromDB.getEmpDatafromDB();
        return employeesDB;
    }


    @GetMapping("/EmployeesJPA")
    public List<Employee> getAllEmployeesJPA() {
        System.out.println("In getAllEmployeesJPA request");

        //List<Employee> employeeList = repository.findAll();

        //List<Employee> employeeList = repository.findByEmployeeName("Prakash");

        List<Employee> employeeList = repository.findByNameAndIDNative("Prakash", 1002);

        return employeeList;
    }

    @PostMapping("/addEmp")
    public void addEmployee(@RequestBody EmployeeData employee)
    {
        System.out.println("In the add method");
        if (employee == null || employee.getEmployeeName() == null || employee.getEmployeeName().isEmpty()) {
           throw new RuntimeException("Name is mandatory!");
       }
         //  Boolean addStatus = employees.add(employee);
           EmployeeService objEmployeeService = new EmployeeService();
          boolean status = objEmployeeService.createEmployeerecord("Employees.txt",employee);
           if (status)
               System.out.println("Employee added successfully.");
    }
//Insert record into database
    @PostMapping("/addnewEmptoDB")
    public void addEmployeetoDB(@RequestBody EmployeeData employee)
    {
        System.out.println("In the add method to DB");
        //TODO:
        if (employee == null|| employee.getEmployeeName() == null || employee.getEmployeeName().isEmpty()) {
            throw new RuntimeException("Name is mandatory!");
        }
        objaddEmptoDB.addEmptoDB(employee);
//        boolean status = objEmployeeService.createEmployeerecord("Employees.txt",employee);
//        if (status)
//            System.out.println("Employee added successfully.");
    }

    @PostMapping("/addEmpJPA")
    public void addEmployeeJPA(@RequestBody Employee employee)
    {
       //TODO: write jpa implementation..
        System.out.println("In addEmpJPA request");
        repository.save(employee);
    }

    // GET all employees
//    @GetMapping("/hello")
//    public List<Employee> getAllEmployees() {
//        EmployeeService objEmployeeService = new EmployeeService();
//        List<Employee> employees1 = objEmployeeService.buildEmployeeList();
//        //return employees;
//        return employees1;
//    }

    // GET employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeByIdJPA(@PathVariable Long id) {
        System.out.println("In getEmployeeByIdJPA request");
        return repository.findById(id);
    }

    //PUT request
    @PutMapping("/{id}")
    public void updateEmployeeJPA(@PathVariable Long id)
    {
        //System.out.println("In updateEmployeeJPA request");


    }
}