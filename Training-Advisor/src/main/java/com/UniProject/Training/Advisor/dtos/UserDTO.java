package com.UniProject.Training.Advisor.dtos;

import com.UniProject.Training.Advisor.Models.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserDTO {

        private String username;

        private String password;
        @Enumerated(EnumType.STRING)
        private Role role;

        public Role getRole() {
        return role;
    }

        public void setRole(Role role) {
        this.role = role;
    }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }



        public void setPassword(String password) {
            this.password = password;
        }
        public UserDTO(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        }
}