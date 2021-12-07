package com.employee.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmployeeServiceException extends RuntimeException {

    private InternalStandardError error;

    public EmployeeServiceException(InternalStandardError error) {
        super(error.getErrorMessage());
        this.error = error;
    }

    public EmployeeServiceException(InternalStandardError error, String message) {
        super(message);
        this.error = error;
    }
}
