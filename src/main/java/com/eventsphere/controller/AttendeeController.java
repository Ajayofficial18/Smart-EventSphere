package com.eventsphere.controller;


import com.eventsphere.entity.User;
import com.eventsphere.services.AttendeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendee")
@CrossOrigin(origins = "*")
public class AttendeeController {

    private final AttendeeService attendeeService;
    public AttendeeController(AttendeeService attendeeService){
        this.attendeeService = attendeeService;
    }

    // Register an attendee for an event
    @PostMapping("/register/{eventId}/{userId}")
    public String registerAttendee(@PathVariable Long eventId, @PathVariable Long userId) {
        return attendeeService.registerAttendee(eventId, userId);
    }

    // Fetch all attendees for a specific event (Accessible only by organizers)
    @GetMapping("/event/{eventId}")
    public List<User> getAttendeesByEvent(@PathVariable Long eventId) {
        return attendeeService.getAttendeesByEvent(eventId);
    }

}
