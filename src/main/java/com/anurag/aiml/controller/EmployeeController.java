package com.anurag.aiml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.aiml.dto.EmployeeDto;
import com.anurag.aiml.entity.Employee;
import com.anurag.aiml.service.EmployeeService;

import jakarta.validation.Valid;

//localhost:8080/employee/delete
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
      @Autowired
      private EmployeeService service;

      @GetMapping("/get")
      public List<Employee> getAllEmployees() {
            return service.getAllEmployees();
      }

      @PostMapping("/login")
      public ResponseEntity<?> login(@RequestBody Employee emp) {
            return service.login(emp);
      }

      @PostMapping("/{id}")
      public Employee getEmployeeByid(@PathVariable Long id) {
            return service.getEmployeeByid(id);
      }

      @PostMapping("/register")
      public Employee createEmployee(@Valid @RequestBody EmployeeDto dto) {
            return service.createEmployee(dto);
      }

      @PutMapping("/{id}") // localhost:8080/employee/3
      @PreAuthorize("hasRole('ADMIN')")
      public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
            return service.updateEmployee(id, employee);
      }

      // localhost:8080/employee/3
      @DeleteMapping("/{id}")
      @PreAuthorize("hasRole('ADMIN')")
      public String deleteEmployee(@PathVariable Long id) {
            return service.deleteEmployee(id);
      }
}
