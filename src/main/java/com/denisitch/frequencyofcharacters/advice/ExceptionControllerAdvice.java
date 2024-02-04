package com.denisitch.frequencyofcharacters.advice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List <String>> validationException(ConstraintViolationException e) {
        List<String> collect = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .toList();
        return new ResponseEntity<>(collect, HttpStatus.BAD_REQUEST);
    }
}
