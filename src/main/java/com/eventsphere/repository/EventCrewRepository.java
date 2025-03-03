package com.eventsphere.repository;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventCrewRepository extends JpaRepository<Crew, Long> {

    List<Crew> findByEventId(Long eventId);

    @Modifying
    @Query("DELETE FROM EventCrew ec WHERE ec.event = :event")
    void deleteByEvent(@Param("event") Event event);
}
