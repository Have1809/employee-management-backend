package com.anurag.aiml.entity;

import com.anurag.aiml.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String name;
      @Enumerated(EnumType.STRING)
      private Role role;
      private String email;
      private String password;

      public Employee() {

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

      public Long getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public void setId(Long id) {
            this.id = id;
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