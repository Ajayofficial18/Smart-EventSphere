package com.eventsphere.services;

import com.eventsphere.entity.User;

import java.util.List;

public interface EventSpeakerService {
    String assignSpeakerToEvent(Long eventId, Long userId);
    List<User> getSpeakersByEvent(Long eventId);
}
