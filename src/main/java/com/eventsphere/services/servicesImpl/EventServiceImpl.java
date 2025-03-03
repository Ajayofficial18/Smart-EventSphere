package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.EventRepo;
import com.eventsphere.repository.UserRepo;
import com.eventsphere.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Event createEvent(Event event, Long organizerId) {
        User organizer = userRepo.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));

        if (organizer.getRole() != Role.ORGANIZER) {
            throw new RuntimeException("User is not an organizer");
        }

        event.setCreatedBy(organizer);
        return eventRepo.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<Event> getEventsByOrganizer(Long organizerId) {
        return eventRepo.findByCreatedById(organizerId);
    }

    @Override
    public Event updateEvent(Long eventId, Event updatedEvent) {
        System.out.println(eventRepo.findById(eventId));
        Event existingEvent = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        existingEvent.setEventName(updatedEvent.getEventName());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setEventDateTime(updatedEvent.getEventDateTime());
        existingEvent.setVenue(updatedEvent.getVenue());
        existingEvent.setCreatedBy(updatedEvent.getCreatedBy());
        existingEvent.setAttendees(updatedEvent.getAttendees());
        existingEvent.setCrewMembers(updatedEvent.getCrewMembers());
        existingEvent.setSpeakers(updatedEvent.getSpeakers());
        existingEvent.setUpdatedAt(updatedEvent.getUpdatedAt());

        return eventRepo.save(existingEvent);
    }

    @Override
    public Event deleteEvent(Long eventId) {
        //eventRepository.findById(eventId).orElseThrow(()-> new RuntimeException("event not found"));
        if(eventRepo.existsById(eventId)){
            Event event = eventRepo.findById(eventId).get();
            eventRepo.deleteById(eventId);
            return event;

        }
        return null;
        //return "Event Cannot be deleted,event not found";
    }
}
