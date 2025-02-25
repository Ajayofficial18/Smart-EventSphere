package com.eventsphere.controller;


import com.eventsphere.entity.User;
import com.eventsphere.services.EventAttendeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendee")
@CrossOrigin(origins = "*")
public class EventAttendeeController {

    private final EventAttendeeService eventAttendeeService;
    public EventAttendeeController(EventAttendeeService eventAttendeeService){
        this.eventAttendeeService=eventAttendeeService;
    }

    // Register an attendee for an event
    @PostMapping("/register/{eventId}/{userId}")
    public String registerAttendee(@PathVariable Long eventId, @PathVariable Long userId) {
        return eventAttendeeService.registerAttendee(eventId, userId);
    }

    // Fetch all attendees for a specific event (Accessible only by organizers)
    @GetMapping("/event/{eventId}")
    public List<User> getAttendeesByEvent(@PathVariable Long eventId) {
        return eventAttendeeService.getAttendeesByEvent(eventId);
    }

}
