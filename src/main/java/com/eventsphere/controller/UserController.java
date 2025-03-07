package com.eventsphere.controller;


import com.eventsphere.dto.SignUpUserDto;
import com.eventsphere.entity.User;
import com.eventsphere.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }

    // 1. Register User
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody SignUpUserDto newUser) {
        String result = userService.registerUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 2. Get User by ID
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // 3. Update User Profile
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser) {
        User user = userService.updateUser(updatedUser);
        return ResponseEntity.ok(user);
    }
}

