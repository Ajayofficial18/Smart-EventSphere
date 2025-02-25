package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.EventRepository;
import com.eventsphere.repository.UserRepository;
import com.eventsphere.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Event createEvent(Event event, Long organizerId) {
        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));

        if (organizer.getRole() != Role.ORGANIZER) {
            throw new RuntimeException("User is not an organizer");
        }

        event.setCreatedBy(organizer);
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<Event> getEventsByOrganizer(Long organizerId) {
        return eventRepository.findByCreatedById(organizerId);
    }

    @Override
    public Event updateEvent(Long eventId, Event updatedEvent) {
        System.out.println(eventRepository.findById(eventId));
        Event existingEvent = eventRepository.findById(eventId)
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

        return eventRepository.save(existingEvent);
    }

    @Override
    public Event deleteEvent(Long eventId) {
        //eventRepository.findById(eventId).orElseThrow(()-> new RuntimeException("event not found"));
        if(eventRepository.existsById(eventId)){
            Event event = eventRepository.findById(eventId).get();
            eventRepository.deleteById(eventId);
            return event;

        }
        return null;
        //return "Event Cannot be deleted,event not found";
    }
}
