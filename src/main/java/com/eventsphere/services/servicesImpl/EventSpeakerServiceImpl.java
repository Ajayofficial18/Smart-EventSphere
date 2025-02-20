package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.EventSpeaker;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.EventRepository;
import com.eventsphere.repository.SpeakerRepository;
import com.eventsphere.repository.UserRepository;
import com.eventsphere.services.EventSpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventSpeakerServiceImpl implements EventSpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String assignSpeakerToEvent(Long eventId, Long userId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User speaker = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (speaker.getRole() != Role.SPEAKER) {
            throw new RuntimeException("User is not a speaker");
        }

        EventSpeaker eventSpeaker = new EventSpeaker();
        eventSpeaker.setEvent(event);
        eventSpeaker.setSpeaker(speaker);
        speakerRepository.save(eventSpeaker);

        return "User assigned as speaker successfully!";

    }

    @Override
    public List<User> getSpeakersByEvent(Long eventId) {
        return speakerRepository.findByEventId(eventId)
                .stream()
                .map(EventSpeaker::getSpeaker)
                .collect(Collectors.toList());
    }
}
