package com.eventsphere.services;

public interface EmailNotificationService {
    void sendEmail(String recipientEmail, String subject, String body);
}
