package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeService employeeService;

    public String markAttendance(Attendance attendance){
        Long empId = attendance.getEmployee().getEmpId();

        if (employeeService.getById(empId) == null) {
            return "Employee not found";
        }

        LocalDate date = attendance.getAttendanceDate();

        if (attendanceRepository.existsByEmployee_empIdAndAttendanceDate(empId, date)) {
            return "Attendance already marked for this date";
        }

        attendanceRepository.save(attendance);

        return "Attendance marked successfully";
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}
