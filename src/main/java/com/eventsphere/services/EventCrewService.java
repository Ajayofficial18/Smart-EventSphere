package com.eventsphere.services;

import com.eventsphere.entity.User;

import java.util.List;

public interface EventCrewService {
    String assignCrewToEvent(Long eventId, Long userId);
    List<User> getCrewMembersByEvent(Long eventId);
//    String removeCrewFromEvent(Long eventId, Long userId);
}
