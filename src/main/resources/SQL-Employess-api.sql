show databases;
create database sqlassdb;
use sqlassdb;
show tables;
create table Employee(EmpId int PRIMARY KEY, EmpName varchar(30) , EmpSalary decimal(8,0)); 
insert into Employee values(1001,"Ravi",50000.00);
insert into Employee values (1002,"Prakash",70000.00),(1003,"Bhaskar",60000.00),(1004,"Suraj",20000.00),
(1005,"Bhanu",10000.00),(1006,"Aditya",25000.00);
select * from Employee;
select * from Employee where EmpSalary>50000.00;
update Employee set EmpSalary = 60000.00 where EmpId=1001;
select AVG(EmpSalary) as avg_sal from Employee; 
delete from Employee where  EmpSalary < 30000.00;
Select * from Employee;
drop table employee;
create table Employee(EmployeeId int PRIMARY KEY, EmployeeName  varchar(50),EmployeeSalary decimal(10,0),EmployeeDepartment varchar(20)); 
select * from Employee;
insert into Employee values (1001,"Prakash",70000.00,"Admin"),(1002,"Bhaskar",60000.00,"HR"),(1003,"Suraj",20000.00,"Production"),
(1005,"Bhanu",10000.00,"Research"),(1006,"Aditya",25000.00,"Automation");
Select * from Employee;
insert into Employee values (1009,"Mitra",45000.0,"Admin");
 


