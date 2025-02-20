package com.eventsphere.controller;


import com.eventsphere.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final com.eventsphere.services.UserServices userService;

    public UserController(com.eventsphere.services.UserServices userService) {
        this.userService = userService;
    }

    // 1. Register User
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // 2. Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // 3. Update User Profile
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(updatedUser);
        return ResponseEntity.ok(user);
    }

    // 4. Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }


//    @PostMapping("/signup")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User savedUser = userServices.registerUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
//        // Authentication logic will be implemented here
//        return ResponseEntity.ok("Login successful");
//    }

//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userServices.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
}