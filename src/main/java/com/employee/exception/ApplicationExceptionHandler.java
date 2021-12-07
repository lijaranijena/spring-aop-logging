package com.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(EmployeeServiceException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeServiceException ex){
        return new ResponseEntity<>(ErrorResponse
                .builder()
                .errorCode(ex.getError().getErrorCode())
                .errorMsg(ex.getMessage())
                .localDateTime(LocalDateTime.now(ZoneOffset.UTC))
                .build(),ex.getError().getHttpStatus());
    }
}
