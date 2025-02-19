package com.eventsphere.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "event_attendees")
public class EventAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User attendee;

    public EventAttendee() {
    }

    public EventAttendee(Long id, Event event, User attendee) {
        this.id = id;
        this.event = event;
        this.attendee = attendee;
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

    public User getAttendee() {
        return attendee;
    }

    public void setAttendee(User attendee) {
        this.attendee = attendee;
    }

    @Override
    public String toString() {
        return "EventAttendee{" +
                "id=" + id +
                ", event=" + event +
                ", attendee=" + attendee +
                '}';
    }
}
