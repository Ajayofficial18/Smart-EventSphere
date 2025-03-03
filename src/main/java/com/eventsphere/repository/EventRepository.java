package com.eventsphere.repository;

import com.eventsphere.entity.Event;
import com.eventsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    //List<Event> findByOrganizer(User organizer);

    List<Event> findByCreatedById(Long organizerId);

    @Modifying
    @Query("DELETE FROM Event e WHERE e.createdBy = :user")
    void deleteByCreatedBy(@Param("user") User user);
}
