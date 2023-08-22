package com.example.firstproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler
    public ResponseEntity<StudentError> handleStudentNot(StudentNotFound studentNotFound) {
        StudentError error = new StudentError();
        error.setMessage("student not found");
        error.setStatusCode(studentNotFound.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentError> globalException(Exception exception) {
        StudentError errorResp = new StudentError();
        errorResp.setStatusCode("Globally Exception Handler ");
        errorResp.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
    }
}
