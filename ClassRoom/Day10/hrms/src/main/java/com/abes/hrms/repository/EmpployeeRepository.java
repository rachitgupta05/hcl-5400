package com.abes.hrms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpployeeRepository {
    double squareroot(double d);
    String empData();
    int add(int a, int b);
    int greatestNumber(int a, int b);
}
