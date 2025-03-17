package com.project.ems.exceptions;

import com.project.ems.entity.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e){

        EmployeeErrorResponse err = new EmployeeErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
