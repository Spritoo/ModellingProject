package com.UniProject.Training.Advisor.Services;

import com.UniProject.Training.Advisor.dtos.LoginDTO;
import com.UniProject.Training.Advisor.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.aspectj.apache.bcel.Repository;

public interface UserService {
    UserDTO signUp(UserDTO userDTO);
    UserDTO signIn(LoginDTO loginDTO);
}