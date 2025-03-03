package com.eventsphere.services;

public interface EmailService {
    void sendEmail(String recipientEmail, String subject, String body);
}
