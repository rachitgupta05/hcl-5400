package com.abes.hrms.model;

import com.abes.hrms.repository.EmployeeRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {
    @Autowired
    private EmployeeRepositoryImple emprepo;

    public int add(int a, int b){
        return emprepo.add(a,b);
    }

    public double squareRoot(double d){
        return emprepo.squareroot(d);
    }

    public int greatestNumber(int a, int b){
        return emprepo.greatestNumber(a,b);
    }
}


