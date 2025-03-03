package com.eventsphere.repository;

import com.eventsphere.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendeeRepo extends JpaRepository<Attendee,Long> {
    List<Attendee> findByEventId(Long eventId);
}
