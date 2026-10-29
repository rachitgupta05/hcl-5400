package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/user/attendance")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/markattendance")
    public String markAttendance(@RequestBody Attendance attendance){
        return attendanceService.markAttendance(attendance);
    }

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }
}
