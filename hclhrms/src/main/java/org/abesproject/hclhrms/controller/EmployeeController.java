package org.abesproject.hclhrms.controller;

import org.abesproject.hclhrms.EmployeeServiceImp;
import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("/")
    public String welcome(){
        return "<h1>Welcome to HRMS App<h1/>";
    }

    @GetMapping("/addemp")
    public String addNewEmployee(){
        return employeeServiceImp.addEmp();
    }

    @GetMapping("/getemp")
    public List<Employee> getEmployees(){
        return employeeServiceImp.getEmp();
    }

    @GetMapping("/getempbyid/{id}")
    public Employee getEmpById(@PathVariable("id") long emp_id){
        return employeeServiceImp.getEmpById(emp_id);
    }

    @GetMapping("/addinbulk")
    public String addBulk(){
        return employeeServiceImp.addEmpBulk();
    }
}
