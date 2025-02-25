package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.EventAttendee;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.EventAttendeeRepository;
import com.eventsphere.repository.EventRepository;
import com.eventsphere.repository.UserRepository;
import com.eventsphere.services.EventAttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventAttendeeServiceImpl implements EventAttendeeService {

    @Autowired
    private EventAttendeeRepository eventAttendeeRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerAttendee(Long eventId, Long userId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User attendee = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (attendee.getRole() != Role.ATTENDEE) {
            throw new RuntimeException("User is not an attendee");
        }

        EventAttendee eventAttendee = new EventAttendee();
        eventAttendee.setEvent(event);
        eventAttendee.setAttendee(attendee);
        eventAttendeeRepository.save(eventAttendee);

        return "User registered as an attendee successfully!";
    }

    @Override
    public List<User> getAttendeesByEvent(Long eventId) {
        return eventAttendeeRepository.findByEventId(eventId)
                .stream()
                .map(EventAttendee::getAttendee)
                .collect(Collectors.toList());
    }
}
