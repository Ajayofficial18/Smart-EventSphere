package com.eventsphere.controller;


import com.eventsphere.entity.User;
import com.eventsphere.services.EventCrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crew")
@CrossOrigin(origins = "*")
public class CrewController {

    @Autowired
    private EventCrewService crewService;

    // Register a Crew Member for an Event
    @PostMapping("/register/{eventId}/{userId}")
    public ResponseEntity<String> registerCrew(@PathVariable Long eventId, @PathVariable Long userId) {
        String response = crewService.assignCrewToEvent(eventId, userId);
        return ResponseEntity.ok(response);
    }

    // Get all Crew Members for an Event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<User>> getCrewByEvent(@PathVariable Long eventId) {
        List<User> crewMembers = crewService.getCrewMembersByEvent(eventId);
        return ResponseEntity.ok(crewMembers);
    }

    // Remove a Crew Member from an Event
//    @DeleteMapping("/remove/{eventId}/{userId}")
//    public ResponseEntity<String> removeCrew(@PathVariable Long eventId, @PathVariable Long userId) {
//        String response = crewService.(eventId, userId);
//        return ResponseEntity.ok(response);
//    }

}
