package com.eventsphere.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "event_speakers")
public class EventSpeaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User speaker;

    public EventSpeaker() {
    }

    public EventSpeaker(Long id, Event event, User speaker) {
        this.id = id;
        this.event = event;
        this.speaker = speaker;
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

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "EventSpeaker{" +
                "id=" + id +
                ", event=" + event +
                ", speaker=" + speaker +
                '}';
    }
}
