package com.upc.crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// ControllerAdvice: Se encarga de controlar todas las excepciones de la aplicación
@ControllerAdvice
public class EmployeeExceptionController {
    @ExceptionHandler(value = com.upc.crud.exception.EmployeeNotFoundException.class)
    public ResponseEntity<Object> exception(com.upc.crud.exception.EmployeeNotFoundException exception) {
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }
}
