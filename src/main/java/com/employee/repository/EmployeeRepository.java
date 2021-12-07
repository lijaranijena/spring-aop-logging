package com.employee.repository;

import com.employee.exception.EmployeeServiceException;
import com.employee.exception.InternalStandardError;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {


    public String getEmployeeName(String name) {


        if (name.equals("NA")) {
            throw new EmployeeServiceException(InternalStandardError.USER_NOT_FOUND);
        }

        if (name.equals("Lija")) {
            throw new EmployeeServiceException(InternalStandardError.INVALID_INPUT, "lija is not a valid name");
        }
        return "Dhananjaya";
    }
}
