package com.eventsphere.entity;



import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_notifications")
public class EmailNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User recipient;  // User who receives the email.

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, length = 5000)
    private String body;

    @Column(nullable = false)
    private LocalDateTime sentAt = LocalDateTime.now();

    public EmailNotification() {
    }

    public EmailNotification(Long id, User recipient, String subject, String body, LocalDateTime sentAt) {
        this.id = id;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "EmailNotification{" +
                "id=" + id +
                ", recipient=" + recipient +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
}
