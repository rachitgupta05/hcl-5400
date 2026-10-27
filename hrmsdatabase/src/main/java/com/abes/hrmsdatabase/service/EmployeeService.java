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

    public Employee getById(Long emp_id){
        return employeeRepository.findById(emp_id).orElse(null);
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

    public String updateById(Long emp_id, Employee updated){
        Employee e=getById(emp_id);

        if(e==null){
            return "Employee not found";
        }
        e.setEmp_name(updated.getEmp_name());
        e.setStack(updated.getStack());
        e.setDesignation(updated.getDesignation());
        employeeRepository.save(e);

        return "Employee is updated successfully";
    }

    public String deleteById(long emp_id){
        Employee e=getById(emp_id);

        if(e==null){
            return "Employee not found";
        }

        employeeRepository.deleteById(emp_id);
        return "Employee is deleted successfully";
    }
}
