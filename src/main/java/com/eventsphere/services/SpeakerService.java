package com.eventsphere.services;

import com.eventsphere.entity.User;

import java.util.List;

public interface SpeakerService {
    String assignSpeakerToEvent(Long eventId, Long userId);
    List<User> getSpeakersByEvent(Long eventId);
}
