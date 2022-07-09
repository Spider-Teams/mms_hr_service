package com.mms.hr_service.services;

import com.mms.hr_service.entities.Employee;
import com.mms.hr_service.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<Object> findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return ResponseEntity.ok().body(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public ResponseEntity<Employee> updateEmployee(Employee emp) {
        Optional<Employee> employee = employeeRepository.findById(emp.getId());
        if(employee.isPresent()) {
            return ResponseEntity.ok().body(employeeRepository.save(emp));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
