package com.eventsphere.repository;

import com.eventsphere.entity.EventAttendee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventAttendeeRepository extends JpaRepository<EventAttendee,Long> {
    List<EventAttendee> findByEventId(Long eventId);

    @Modifying
    @Transactional
    @Query("DELETE FROM EventAttendee ea WHERE ea.attendee.id = :userId")
    void deleteByAttendeeId(@Param("userId") Long userId);
}
