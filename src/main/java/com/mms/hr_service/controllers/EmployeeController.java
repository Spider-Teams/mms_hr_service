package com.mms.hr_service.controllers;

import com.mms.hr_service.entities.Employee;
import com.mms.hr_service.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public Iterable<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findEmployeeById(@PathVariable(value = "id") Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        return employeeService.updateEmployee(emp);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
         employeeService.deleteEmployee(id);
    }
}
