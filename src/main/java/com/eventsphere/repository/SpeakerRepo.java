package com.eventsphere.repository;

import com.eventsphere.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepo extends JpaRepository<Speaker, Long> {
    List<Speaker> findByEventId(Long eventId);
}
