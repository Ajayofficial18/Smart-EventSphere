package com.eventsphere.entity;


import com.eventsphere.enums.ApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "application_forms")
public class ApplicationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;  // The user submitting the application.

    @Column(nullable = false, length = 5000)
    private String formData;  // JSON format or a structured string.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status = ApplicationStatus.PENDING;  // Default status.

    @Column(nullable = false)
    private LocalDateTime submittedAt = LocalDateTime.now();

    public ApplicationForm() {
    }

    public ApplicationForm(Long id, User user, String formData, ApplicationStatus status, LocalDateTime submittedAt) {
        this.id = id;
        this.user = user;
        this.formData = formData;
        this.status = status;
        this.submittedAt = submittedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    @Override
    public String toString() {
        return "ApplicationForm{" +
                "id=" + id +
                ", user=" + user +
                ", formData='" + formData + '\'' +
                ", status=" + status +
                ", submittedAt=" + submittedAt +
                '}';
    }
}
