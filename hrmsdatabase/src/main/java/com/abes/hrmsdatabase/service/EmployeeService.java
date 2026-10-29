package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createNewEmployee(Employee newEmp){
//        Employee e=new Employee(200l, "Rahul", "Java", "Full Stack Developer", "hrms@gmail.com", "123456");
        employeeRepository.save(newEmp);
        return "Employee is created Successfully";
    }

    public String login(Long empId, String password){
        Employee e=getById(empId);

        if(e==null){
            return "Employee not Found";
        }

        if(e.getPassword().equals(password)){
            return "Login Successful";
        }

        return "Invalid password";
    }

    public Employee getById(Long empId){
        return employeeRepository.findById(empId).orElse(null);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public String addInBulk(){
        List<Employee> employees=List.of(new Employee(201l, "Priya", "USER", "Python", "priya@gmail.com", "123"),
                new Employee(202l, "Amit", "ADMIN", "Java","amit@gmail.com", "123"),
                new Employee(203l, "Sneha", "USER", "JavaScript", "sneha@gmail.com", "123"),
                new Employee(204l, "Vikram", "MANAGER", "Spring Boot", "vikram@gmail.com", "123"));
        employeeRepository.saveAll(employees);
        return "Employees added in bulk";
    }

    public String updateById(Long empId, Employee updated){
        Employee e=getById(empId);

        if(e==null){
            return "Employee not found";
        }
        e.setEmpName(updated.getEmpName());
        e.setStack(updated.getStack());
        e.setDesignation(updated.getDesignation());
        e.setEmail(updated.getEmail());
        e.setPassword(updated.getPassword());
        employeeRepository.save(e);

        return "Employee is updated successfully";
    }

    public String deleteById(long empId){
        Employee e=getById(empId);

        if(e==null){
            return "Employee not found";
        }

        employeeRepository.deleteById(empId);
        return "Employee is deleted successfully";
    }
}
