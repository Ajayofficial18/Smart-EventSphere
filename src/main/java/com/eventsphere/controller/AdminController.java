package com.eventsphere.controller;


import com.eventsphere.entity.User;
import com.eventsphere.repository.EventAttendeeRepository;
import com.eventsphere.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final UserServices userService;
    private final EventAttendeeRepository eventAttendeeRepository;

    public AdminController(UserServices userService, EventAttendeeRepository eventAttendeeRepository){
        this.userService=userService;
        this.eventAttendeeRepository=eventAttendeeRepository;
    }


    // ============== update or delete on table \"users\" violates foreign key constraint \"fkdocju8m76a3f8o6ljh2jrn2ra\" on table \"events\"\n  Detail: Key (id)=(1) is still referenced from table \"events\  =========
    // Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        eventAttendeeRepository.deleteByAttendeeId(userId);
        String result = userService.deleteUser(userId);
        return ResponseEntity.ok(result);
    }

    // Get All User
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        var allUsers = userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

}
