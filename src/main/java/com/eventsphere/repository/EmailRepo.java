package com.eventsphere.repository;

import com.eventsphere.entity.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepo extends JpaRepository<EmailNotification, Long> {

    List<EmailNotification> findByRecipientId(Long userId);
    //List<EmailNotification> findByRecipient(User recipient);
}
