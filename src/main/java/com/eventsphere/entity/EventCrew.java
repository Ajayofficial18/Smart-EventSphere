package com.eventsphere.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "event_crew")
public class EventCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User crewMember;
}
