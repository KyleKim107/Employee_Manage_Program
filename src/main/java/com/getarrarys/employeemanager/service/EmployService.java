package com.getarrarys.employeemanager.service;

import com.getarrarys.employeemanager.exception.UserNotFoundException;
import com.getarrarys.employeemanager.model.Employee;
import com.getarrarys.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EmployService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found" ));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);

    }
}
