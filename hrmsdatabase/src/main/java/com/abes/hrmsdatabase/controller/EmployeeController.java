package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/v1/user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String welcome(){
        return "<h1>Welcome to HRMS Application<h1/>";
    }

    @PostMapping("/addemp")
    public String addNewEmployee(@RequestBody Employee newEmp){
        return employeeService.createNewEmployee(newEmp);
    }

    @PostMapping("/login")
    public String login(@RequestParam Long empId, @RequestParam String password){
        return employeeService.login(empId, password);
    }

    @GetMapping("/getbyid/{empId}")
    public Employee getById(@PathVariable Long empId){
        return employeeService.getById(empId);
    }

    @GetMapping("/getemployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/addinbulk")
    public String addInBulk(){
        return employeeService.addInBulk();
    }

    @PutMapping("/updatebyid/{empId}")
    public String updateById(@PathVariable Long empId, @RequestBody Employee updated){
        return employeeService.updateById(empId, updated);
    }

    @DeleteMapping("/deletebyid/{empId}")
    public String deleteById(@PathVariable Long empId){
        return employeeService.deleteById(empId);
    }

}

