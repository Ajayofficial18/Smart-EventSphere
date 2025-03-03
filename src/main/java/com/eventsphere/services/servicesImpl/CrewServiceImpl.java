package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.Crew;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.CrewRepo;
import com.eventsphere.repository.EventRepo;
import com.eventsphere.repository.UserRepo;
import com.eventsphere.services.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CrewServiceImpl implements CrewService {

    @Autowired
    private CrewRepo crewRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public String assignCrewToEvent(Long eventId, Long userId) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User crewMember = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (crewMember.getRole() != Role.CREW) {
            throw new RuntimeException("User is not a crew member");
        }

        Crew crew = new Crew();
        crew.setEvent(event);
        crew.setCrewMember(crewMember);
        crewRepo.save(crew);
        return "User assigned as crew successfully!";
    }

    @Override
    public List<User> getCrewMembersByEvent(Long eventId) {
        return crewRepo.findByEventId(eventId)
                .stream()
                .map(Crew::getCrewMember)
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
