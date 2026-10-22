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
        Employee e=getEmpById(emp_id);

        if(e==null){
            return "Employee Not Found";
        }

        emplist.remove(e);
        return "Employee is deleted Successfully";
    }

    @Override
    public String updateById(long emp_id, Employee updated) {
        Employee e=getEmpById(emp_id);

        if(e==null){
            return "Employee Not Found";
        }
        e.setEmp_name(updated.getEmp_name());
        e.setDesignation(updated.getDesignation());
        e.setEmail(updated.getEmail());
        e.setProgStack(updated.getProgStack());

        return "Employee Updated Successfully";

    }
}
