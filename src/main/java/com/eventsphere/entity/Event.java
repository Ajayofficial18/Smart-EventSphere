package com.eventsphere.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private LocalDateTime eventDateTime;

    @Column(nullable = false)
    private String venue;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User createdBy;  // Organizer

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventAttendee> attendees;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventCrew> crewMembers;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventSpeaker> speakers;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Event() {
    }

    public Event(Long id, String eventName, String description, LocalDateTime eventDateTime, String venue, User createdBy, List<EventAttendee> attendees, List<EventCrew> crewMembers, List<EventSpeaker> speakers, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.eventDateTime = eventDateTime;
        this.venue = venue;
        this.createdBy = createdBy;
        this.attendees = attendees;
        this.crewMembers = crewMembers;
        this.speakers = speakers;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<EventAttendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<EventAttendee> attendees) {
        this.attendees = attendees;
    }

    public List<EventCrew> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<EventCrew> crewMembers) {
        this.crewMembers = crewMembers;
    }

    public List<EventSpeaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<EventSpeaker> speakers) {
        this.speakers = speakers;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", description='" + description + '\'' +
                ", eventDateTime=" + eventDateTime +
                ", venue='" + venue + '\'' +
                ", createdBy=" + createdBy +
                ", attendees=" + attendees +
                ", crewMembers=" + crewMembers +
                ", speakers=" + speakers +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
