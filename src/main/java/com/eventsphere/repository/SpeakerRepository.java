package com.eventsphere.repository;

import com.eventsphere.entity.EventSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<EventSpeaker, Long> {
}
