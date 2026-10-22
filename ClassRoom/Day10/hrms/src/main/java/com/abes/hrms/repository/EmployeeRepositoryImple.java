package com.abes.hrms.repository;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepositoryImple implements EmpployeeRepository {
    @Override
    public String empData() {
        return "";
    }

    @Override
    public double squareroot(double d) {
        double result=Math.sqrt(d);
        return result;
    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int greatestNumber(int a, int b) {
        if(a>b) return a;
        return b;
    }
}
