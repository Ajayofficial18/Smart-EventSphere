package com.eventsphere.services;

import com.eventsphere.entity.User;

import java.util.List;

public interface EventAttendeeService {
    String registerAttendee(Long eventId, Long userId);
    List<User> getAttendeesByEvent(Long eventId);
}
