package com.UniProject.Training.Advisor.Controllers;

import com.UniProject.Training.Advisor.Services.UserService;
import com.UniProject.Training.Advisor.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
public class UserController  {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.signUp(userDTO);
        return new ResponseEntity<UserDTO>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserDTO> signIn(@RequestParam String id, @RequestParam String password) {
        UserDTO userDTO = userService.signIn(id, password);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
