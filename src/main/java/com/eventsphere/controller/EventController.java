package com.eventsphere.controller;


import com.eventsphere.entity.Event;
import com.eventsphere.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Create Event
    @PostMapping("/addEvent/{organizerId}")
    public ResponseEntity<Event> createEvent(@PathVariable Long organizerId, @RequestBody Event event) {
        Event newEvent = eventService.createEvent(event, organizerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
    }

    // Get Event by ID
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    // Get All Events
    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    // event by organizer
    @GetMapping("/getEventByOrganizerId/{organizerId}")
    public ResponseEntity<List<Event>> getEventByOrganizer(@PathVariable Long organizerId){
        List<Event> allEventsOfOrganizer = eventService.getEventsByOrganizer(organizerId);
        return ResponseEntity.ok(allEventsOfOrganizer);
    }

    // Delete Event
    @DeleteMapping("deleteEvent/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable Long id) {
        Event result = eventService.deleteEvent(id);
        return ResponseEntity.ok(result);
    }


    // ======== null pointer error =========
    // Update Event
    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(id, updatedEvent);
        return ResponseEntity.ok(event);
    }

}
