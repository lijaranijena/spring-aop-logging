package com.employee.controller;

import com.employee.aop.BoundaryLogger;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class UserController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{eName}")
    @BoundaryLogger
    @ResponseStatus(HttpStatus.CREATED)
    public String getEmployeeName(@PathVariable("eName") String name) {
        return employeeService.getEmployeeName(name);
    }

}
