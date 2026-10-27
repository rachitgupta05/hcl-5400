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

    @GetMapping("/getbyid/{emp_id}")
    public Employee getById(@PathVariable Long emp_id){
        return employeeService.getById(emp_id);
    }

    @GetMapping("/getemployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/addinbulk")
    public String addInBulk(){
        return employeeService.addInBulk();
    }

    @PutMapping("/updatebyid/{emp_id}")
    public String updateById(@PathVariable Long emp_id, @RequestBody Employee updated){
        return employeeService.updateById(emp_id, updated);
    }

    @DeleteMapping("/deletebyid/{emp_id}")
    public String deleteById(@PathVariable Long emp_id){
        return employeeService.deleteById(emp_id);
    }
}

