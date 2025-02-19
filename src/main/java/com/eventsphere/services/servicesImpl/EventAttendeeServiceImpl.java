package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.User;
import com.eventsphere.services.EventAttendeeService;

import java.util.List;

public class EventAttendeeServiceImpl implements EventAttendeeService {
    @Override
    public String registerAttendee(Long eventId, Long userId) {
        return "";
    }

    @Override
    public List<User> getAttendeesByEvent(Long eventId) {
        return List.of();
    }
}
