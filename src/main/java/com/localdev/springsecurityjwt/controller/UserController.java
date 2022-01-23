package com.localdev.springsecurityjwt.controller;

import java.util.List;

import com.localdev.springsecurityjwt.entity.Role;
import com.localdev.springsecurityjwt.entity.User;
import com.localdev.springsecurityjwt.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.created(null).body(userService.saveUser(user));
    }

    @GetMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.created(null).body(userService.saveRole(role));
    }
}