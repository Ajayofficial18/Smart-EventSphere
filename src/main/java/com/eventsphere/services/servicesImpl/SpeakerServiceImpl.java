package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.Speaker;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.EventRepo;
import com.eventsphere.repository.SpeakerRepo;
import com.eventsphere.repository.UserRepo;
import com.eventsphere.services.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepo speakerRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public String assignSpeakerToEvent(Long eventId, Long userId) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User speaker = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (speaker.getRole() != Role.SPEAKER) {
            throw new RuntimeException("User is not a speaker");
        }

        Speaker eventSpeaker = new Speaker();
        eventSpeaker.setEvent(event);
        eventSpeaker.setSpeaker(speaker);
        speakerRepo.save(eventSpeaker);

        return "User assigned as speaker successfully!";

    }

    @Override
    public List<User> getSpeakersByEvent(Long eventId) {
        return speakerRepo.findByEventId(eventId)
                .stream()
                .map(Speaker::getSpeaker)
                .collect(Collectors.toList());
    }
}
