package com.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public enum InternalStandardError {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"E4004","user not found"),
    INVALID_INPUT(HttpStatus.BAD_REQUEST,"E4014","invalid input");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;
}
