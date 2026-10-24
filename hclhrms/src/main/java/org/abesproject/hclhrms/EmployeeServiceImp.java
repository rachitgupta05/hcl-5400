package org.abesproject.hclhrms;

import org.abesproject.hclhrms.entity.Employee;
import org.abesproject.hclhrms.repository.EmployeeRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {

    @Autowired
    private EmployeeRepositoryImple emprepo;

    public String addEmp(){
        Employee emp1=new Employee (200l, "Rahul", "ADMIN","FSD", "admin@gmail.com");
        return emprepo.addEmp(emp1);
    }

    public String addEmpBulk(){
        List<Employee> employees=List.of(new Employee(890, "Ram", "Test engineer", "Python", "abc@gmail.com"),
                new Employee(891, "Shyam", "frontend engineer", "React", "react@gmail.com"),
                new Employee(892, "Mohan", "Backend engineer", "MERN", "mern@gmail.com"),
                new Employee(893, "Ramesh", "full stack engineer", "java", "java@gmail.com"));
        return emprepo.addEmpBulk(employees);
    }



    public List<Employee> getEmp(){
        return emprepo.getEmp();
    }

    public Employee getEmpById(long emp_id){
        return emprepo.getEmpById(emp_id);
    }

    public String updateById(long emp_id, Employee updated){
        return emprepo.updateById(emp_id, updated);
    }

    public String deleteById(long emp_id){
        return emprepo.deleteById(emp_id);
    }
}
