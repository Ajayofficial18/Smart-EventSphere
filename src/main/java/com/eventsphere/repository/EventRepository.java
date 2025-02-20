package com.eventsphere.repository;

import com.eventsphere.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
<<<<<<< Updated upstream
    List<Event> findByOrganizer(User organizer);
=======

    List<Event> findByCreatedById(Long organizerId);
>>>>>>> Stashed changes
}
