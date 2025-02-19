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

}
