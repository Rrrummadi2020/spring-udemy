package com.example.firstproject.exception;

public class StudentError {
    public String statusCode;
    public String message;

    public StudentError(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public StudentError() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
