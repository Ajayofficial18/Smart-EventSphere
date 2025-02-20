package com.eventsphere.repository;

import com.eventsphere.entity.EventAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventAttendeeRepository extends JpaRepository<EventAttendee,Long> {
    List<EventAttendee> findByEventId(Long eventId);
}
