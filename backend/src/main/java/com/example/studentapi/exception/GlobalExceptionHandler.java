package com.example.studentapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleStudentNotFound(
            StudentNotFoundException ex) {

        return Map.of(
                "error",
                ex.getMessage()
        );
    }
}