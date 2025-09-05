package org.example.employeeapi.controller;

import org.example.config.PropertiesComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
//    private List<EmployeeData> employeeDataList = List.of(
//            new EmployeeData(101, "ABCD", 40000.0, "Production"),
//            new EmployeeData(102, "EFGH", 50000.0, "Research"),
//            new EmployeeData(103, "IJKL", 70000.0, "Development"),
//            new EmployeeData(104, "MNOP", 60000.0, "Admin"),
//            new EmployeeData(105, "QRST", 20000.0, "HR")
//    );
@Autowired
private PropertiesComponent properties;
    final String folder = "\\src\\main\\resources\\";
    final String basePath = System.getProperty("user.dir");
    final String columnSeperator = ",";
    int rowCount = 0;

    public List<EmployeeData> buildEmployeeList(String fileName1) {
String fileName=properties.getFileName();
        System.out.println("File Name from properties file is :-" + fileName);
        List<EmployeeData> employeeList = readFile(fileName);
        return employeeList;
    }
    public boolean createEmployeerecord(String fileNamefrompost,EmployeeData newEmployeerecord){
        return writeToFile(fileNamefrompost,newEmployeerecord);

    }
    public boolean writeToFile(String fileNamefrompost,EmployeeData newEmployeerecord){
        boolean fileStatus = false;
        String filePath = getFilePath(fileNamefrompost);
        System.out.println("File path is from Post:" + filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) { // 'true' for append mode
            String employeeNewData = newEmployeerecord.commaSeparatedString();
            System.out.println("Data converted to string :-" + employeeNewData);
            writer.write(employeeNewData);
            writer.newLine(); // Add a new line before appending
            System.out.println("Data successfully appended to " + fileNamefrompost);
            fileStatus = true;
            return fileStatus;
        }
        catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
            return fileStatus;
        }
    }

    private String getFilePath(String fileName) {
        String fullFilePath = basePath + folder + fileName;
        System.out.println("File path is :" + fullFilePath);
        return fullFilePath;
    }

    public List<EmployeeData> readFile(String fileName)  {
            String filePath = getFilePath(fileName);
            List<EmployeeData> employeeList = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
                String line;
                while((line = br.readLine())!=null)
                {
                    if (rowCount == 0)
                    { rowCount++;}
                    else {
                        rowCount++;
                        String[] empfileData = splitData(line);
                        EmployeeData objEmployee = parseData(empfileData);
                        if (objEmployee != null){
                            employeeList.add(objEmployee);
                        }
                    }
                }
            }
            catch (IOException e) {
                System.err.println("Error:-" + e.getMessage());
                e.fillInStackTrace();
            }
            return employeeList;
        }

        private String[] splitData(String line) {
            // System.out.println(line);
            String[] data = line.split(columnSeperator);
            return data;
        }

        private EmployeeData parseData(String[] empfileData)
        {
            EmployeeData employeeData = null;
            try {
                int no = Integer.parseInt(empfileData[0].trim());
                String name = empfileData[1].trim();
                double salary = Double.parseDouble(empfileData[2].trim());
                String department = empfileData[3].trim();
                employeeData = new EmployeeData(no, name, salary,department);
            }
            catch (Exception e) {
                System.err.println("Skipped line no = " + rowCount + " as invalid data found on line." + e.getMessage());
            }
            return employeeData;
        }
}

