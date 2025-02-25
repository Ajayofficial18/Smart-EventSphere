package com.eventsphere.controller;


import com.eventsphere.entity.User;
import com.eventsphere.services.EventSpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speaker")
@CrossOrigin(origins = "*")
public class SpeakerController {

    @Autowired
    private EventSpeakerService speakerService;

    // Register a Speaker for an Event
    @PostMapping("/register/{eventId}/{userId}")
    public ResponseEntity<String> registerSpeaker(@PathVariable Long eventId, @PathVariable Long userId) {
        String response = speakerService.assignSpeakerToEvent(eventId, userId);
        return ResponseEntity.ok(response);
    }

    // Get all Speakers for an Event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<User>> getSpeakersByEvent(@PathVariable Long eventId) {
        List<User> speakers = speakerService.getSpeakersByEvent(eventId);
        return ResponseEntity.ok(speakers);
    }

}
