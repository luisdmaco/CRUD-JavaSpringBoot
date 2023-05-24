package com.upc.crud.service;

import com.upc.crud.model.Employee;
import java.util.List;

public interface EmployeeService {
    public abstract Employee createEmployee(Employee employee);
    public abstract Employee updateEmployee(Employee employee);
    public abstract Employee getEmployeeById(int id);
    public abstract List<Employee> getAllEmployees();
    public abstract void deleteEmployee(int id);
    public abstract boolean isEmployeeExist(int id);
}
