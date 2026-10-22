package com.abes.hrms.controller;

import com.abes.hrms.model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private DemoEmployee demoEmployee;

    @GetMapping("/")
    public String welcome(){
        return "<h2 style='color: red'>Welcome to HRMS App<h2/>";
    };

    @GetMapping("/add")
    public int getSum(){
        System.out.println("inside /add controller point");
        int result=demoEmployee.add(20, 50);
        System.out.println("result from model = " + result);
        return result;
    }

    @GetMapping("/sqrt")
    public double getSquareRoot(){
        return demoEmployee.squareRoot(16);
    }

    @GetMapping("/greatest")
    public int getGreatest(){
        return demoEmployee.greatestNumber(5,10);
    }
}
