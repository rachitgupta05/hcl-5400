package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeRepositoryImple implements EmployeeRepository{

    List<Employee> emplist=new ArrayList<>();

    @Override
    public String addEmp(Employee emp) {
        emplist.add(emp);
        return "Employee added Successfully";
    }

    @Override
    public String addEmpBulk(List<Employee> employees) {
       emplist.addAll(employees);
       return "Employees added in bulk";

    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpById(long emp_id) {
        return emplist.stream().filter(e->e.getEmp_id()==emp_id).findFirst().orElse(null);
    }

    @Override
    public String deleteById(long emp_id) {
        return "";
    }

    @Override
    public String updateById(long emp_id, Employee updated) {
        return "";
    }
}
