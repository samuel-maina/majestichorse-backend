/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.controllers;

import com.majesticHorse.model.Roles;
import com.majesticHorse.model.User;

import com.majesticHorse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users/")
public class UserController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserService userService;
    
    

    @GetMapping
    public ResponseEntity<?> viewUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }



    @PostMapping("/signup")
    public ResponseEntity<?> saveInstructor(@RequestBody User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        user.setEnabled(false);
        return new ResponseEntity<>(userService.saveUser(user, Roles.INSTRUCTOR), HttpStatus.OK);
    }

    @PostMapping("/administrator/signup")
    public ResponseEntity<?> saveAdministrator(@RequestBody User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        user.setEnabled(false);
        return new ResponseEntity<>(userService.saveUser(user, Roles.ADMINISTRATOR), HttpStatus.OK);
    }

    @PostMapping("/activate")
    public ResponseEntity<?> activate(@RequestBody User user) {
        userService.activateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
