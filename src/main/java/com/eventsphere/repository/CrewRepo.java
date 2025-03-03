package com.eventsphere.repository;

import com.eventsphere.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrewRepo extends JpaRepository<Crew, Long> {
    List<Crew> findByEventId(Long eventId);
}
