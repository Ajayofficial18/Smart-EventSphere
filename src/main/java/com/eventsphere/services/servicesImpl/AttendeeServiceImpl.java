package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.Attendee;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.AttendeeRepo;
import com.eventsphere.repository.EventRepo;
import com.eventsphere.repository.UserRepo;
import com.eventsphere.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendeeServiceImpl implements AttendeeService {

    @Autowired
    private AttendeeRepo attendeeRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public String registerAttendee(Long eventId, Long userId) {

        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User attendee = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (attendee.getRole() != Role.ATTENDEE) {
            throw new RuntimeException("User is not an attendee");
        }

        Attendee eventAttendee = new Attendee();
        eventAttendee.setEvent(event);
        eventAttendee.setAttendee(attendee);
        attendeeRepo.save(eventAttendee);

        return "User registered as an attendee successfully!";
    }

    @Override
    public List<User> getAttendeesByEvent(Long eventId) {
        return attendeeRepo.findByEventId(eventId)
                .stream()
                .map(Attendee::getAttendee)
                .collect(Collectors.toList());
    }
}
