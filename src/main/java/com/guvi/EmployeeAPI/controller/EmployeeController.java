package com.guvi.EmployeeAPI.controller;

import com.guvi.EmployeeAPI.model.Employee;
import com.guvi.EmployeeAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ✅ Add Employee (Supports both JSON & Form Data)
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee added successfully!");
    }



    // ✅ Get all employees
    @GetMapping("/displayAll")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Get Employee by ID
    @GetMapping("/display/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.isPresent() ? ResponseEntity.ok(employee.get()) :
                ResponseEntity.status(404).body("Employee not found!");
    }
}
