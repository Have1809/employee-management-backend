package com.anurag.aiml.dto;

public class LoginResposnseDto {
      private String token;
      private String email;

      public LoginResposnseDto(String token, String email) {
            this.token = token;
            this.email = email;
      }

      public String getToken() {
            return token;
      }

      public void setToken(String token) {
            this.token = token;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

}
