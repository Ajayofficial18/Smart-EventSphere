package com.eventsphere.repository;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    List<Speaker> findByEventId(Long eventId);
    @Modifying
    @Query("DELETE FROM EventSpeaker es WHERE es.event = :event")
    void deleteByEvent(@Param("event") Event event);
}
