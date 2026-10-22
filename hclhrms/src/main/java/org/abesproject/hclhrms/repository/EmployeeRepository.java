package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EmployeeRepository {

    String addEmp(Employee emp);

    String addEmpBulk(List<Employee> employees);

    List<Employee> getEmp();

    Employee getEmpById(long emp_id);

    String deleteById(long emp_id);

    String updateById(long emp_id, Employee updated);

}