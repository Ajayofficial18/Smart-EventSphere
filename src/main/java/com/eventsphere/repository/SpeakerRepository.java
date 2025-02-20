package com.eventsphere.repository;

import com.eventsphere.entity.EventSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<EventSpeaker, Long> {
    List<EventSpeaker> findByEventId(Long eventId);
}
