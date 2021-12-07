package com.employee.service;


import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //@BoundaryLogger
    public String getEmployeeName(String employeeName){
        return employeeRepository.getEmployeeName(employeeName);
    }
}
