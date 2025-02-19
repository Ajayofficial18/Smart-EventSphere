package com.eventsphere.repository;

import com.eventsphere.entity.EventCrew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventCrewRepository extends JpaRepository<EventCrew, Long> {

    List<EventCrew> findByEventId(Long eventId);
}
