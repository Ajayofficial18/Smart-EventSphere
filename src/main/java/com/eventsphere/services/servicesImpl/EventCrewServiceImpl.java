package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.EventCrew;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.EventCrewRepository;
import com.eventsphere.repository.EventRepository;
import com.eventsphere.repository.UserRepository;
import com.eventsphere.services.EventCrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventCrewServiceImpl implements EventCrewService {

    @Autowired
    private EventCrewRepository eventCrewRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String assignCrewToEvent(Long eventId, Long userId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User crewMember = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (crewMember.getRole() != Role.CREW) {
            throw new RuntimeException("User is not a crew member");
        }

        EventCrew eventCrew = new EventCrew();
        eventCrew.setEvent(event);
        eventCrew.setCrewMember(crewMember);
        eventCrewRepository.save(eventCrew);
        return "User assigned as crew successfully!";
    }

    @Override
    public List<User> getCrewMembersByEvent(Long eventId) {
        return eventCrewRepository.findByEventId(eventId)
                .stream()
                .map(EventCrew::getCrewMember)
                .collect(Collectors.toList());
    }

//    @Override
//    public String removeCrewFromEvent(Long eventId, Long userId) {
//        Event event = eventRepository.findById(eventId)
//                .orElseThrow(() -> new RuntimeException("Event not found"));
//
//        User crewMember = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (crewMember.getRole() != Role.CREW) {
//            throw new RuntimeException("User is not a crew member");
//        }
//        eventCrewRepository.deleteById();
//    }
}
