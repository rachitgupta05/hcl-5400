package org.abesproject.hclhrms.controller;

import org.abesproject.hclhrms.EmployeeServiceImp;
import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/updatebyid/{id}")
    public String updateEmp(@PathVariable("id") long emp_id, @RequestBody Employee updated){
        return employeeServiceImp.updateById(emp_id, updated);
    }

    @GetMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable("id") long emp_id){
        return employeeServiceImp.deleteById(emp_id);
    }

}
