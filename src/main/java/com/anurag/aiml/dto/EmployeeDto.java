package com.anurag.aiml.dto;

import com.anurag.aiml.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeDto {
      @NotBlank(message = "Name is required")
      private String name;
      @Enumerated(EnumType.STRING)
      private Role role;
      @NotBlank(message = "Email is required")
      private String email;
      @NotBlank(message = "Password is required")
      @Size(min = 8, message = "Atleast password required 8 char")
      private String password;

      public EmployeeDto() {

      }

      public void setEmail(String email) {
            this.email = email;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public String getEmail() {
            return email;
      }

      public String getPassword() {
            return password;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public Role getRole() {
            return role;
      }

      public void setRole(Role role) {
            this.role = role;
      }

}
