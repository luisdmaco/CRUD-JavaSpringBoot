package com.upc.crud.controller;

import com.upc.crud.exception.EmployeeNotFoundException;
import com.upc.crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upc.crud.service.EmployeeService;

@RestController
public class EmployeeServiceController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee is created successfully with id= " + employee.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, int id) {
        boolean isExist = employeeService.isEmployeeExist(id);
        if(!isExist) {
            throw new EmployeeNotFoundException();
        } else{
            employee.setId(id);
            employeeService.updateEmployee(employee);
            return new ResponseEntity<>("Employee is updated successfully", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {
        boolean isExist = employeeService.isEmployeeExist(id);
        if(!isExist) {
            throw new EmployeeNotFoundException();
        } else{
            Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) {
        boolean isExist = employeeService.isEmployeeExist(id);
        if(!isExist) {
            throw new EmployeeNotFoundException();
        } else{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
        }
    }
}
