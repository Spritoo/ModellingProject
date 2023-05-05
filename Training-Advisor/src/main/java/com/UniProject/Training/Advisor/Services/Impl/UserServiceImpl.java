package com.UniProject.Training.Advisor.Services.Impl;

import com.UniProject.Training.Advisor.Models.Role;
import com.UniProject.Training.Advisor.Models.User;
import com.UniProject.Training.Advisor.Repositories.UserRepository;
import com.UniProject.Training.Advisor.Services.UserService;
import com.UniProject.Training.Advisor.dtos.LoginDTO;
import com.UniProject.Training.Advisor.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO signUp(UserDTO userDTO) {
        User existingUser = userRepository.findByUsername(userDTO.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already taken");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        userRepository.save(user);

        return new UserDTO(user.getId().toString(), user.getUsername(), user.getRole());
    }

    @Override
    public UserDTO signIn(String id, String password) {
        User user = userRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (password== user.getPassword()) {
            throw new BadCredentialsException("Invalid password");
        }

        return new UserDTO(user.getId().toString(), user.getUsername(), user.getRole());
    }
}