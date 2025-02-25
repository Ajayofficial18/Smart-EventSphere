package com.eventsphere.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "event_crew")
public class EventCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User crewMember;

    public EventCrew() {
    }

    public EventCrew(Long id, Event event, User crewMember) {
        this.id = id;
        this.event = event;
        this.crewMember = crewMember;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(User crewMember) {
        this.crewMember = crewMember;
    }

    @Override
    public String toString() {
        return "EventCrew{" +
                "id=" + id +
                ", event=" + event +
                ", crewMember=" + crewMember +
                '}';
    }
}
