package com.anurag.aiml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anurag.aiml.dto.EmployeeDto;
import com.anurag.aiml.dto.LoginResposnseDto;
import com.anurag.aiml.entity.Employee;
import com.anurag.aiml.repository.EmployeeRepository;

@Service
public class EmployeeService {
      @Autowired
      private EmployeeRepository repo;

      @Autowired
      private PasswordEncoder encoder;

      @Autowired
      private JwtService Jservice;

      public List<Employee> getAllEmployees() {
            return repo.findAll();
      }

      public Employee getEmployeeByid(Long id) {
            return repo.findById(id).orElse(null);
      }

      public Employee createEmployee(EmployeeDto dto) {
            Employee employee = new Employee();
            employee.setName(dto.getName());
            employee.setRole(dto.getRole());
            employee.setEmail(dto.getEmail());
            employee.setPassword(encoder.encode(dto.getPassword()));

            return repo.save(employee);
      }

      public Employee updateEmployee(Long id, Employee newemployee) {
            Employee existingEmployee = repo.findById(id).orElse(null);
            if (existingEmployee != null) {
                  existingEmployee.setName(newemployee.getName());
                  existingEmployee.setRole(newemployee.getRole());
                  existingEmployee.setEmail(newemployee.getEmail());

                  existingEmployee.setPassword(encoder.encode(newemployee.getPassword()));

                  return repo.save(existingEmployee);
            }
            return null;
      }

      public String deleteEmployee(Long id) {
            if (repo.existsById(id)) {
                  repo.deleteById(id);
                  return "Employee deleted successfully";
            }
            return "employee not found";
      }

      public ResponseEntity<?> login(Employee employee) {
            Employee existingEmp = repo.findByEmail(employee.getEmail());
            if (existingEmp == null) {
                  return ResponseEntity
                              .status(HttpStatus.UNAUTHORIZED)
                              .body("Email is Wrong");
            }
            if (!encoder.matches(employee.getPassword(), existingEmp.getPassword())) {
                  return ResponseEntity
                              .status(HttpStatus.UNAUTHORIZED)
                              .body("Password is Wrong...");
            }
            String token = Jservice.generateToken(employee.getEmail());

            LoginResposnseDto dto = new LoginResposnseDto(token, employee.getEmail());

            return ResponseEntity.ok(dto);
      }
}
