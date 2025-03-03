package com.eventsphere.services.servicesImpl;

import com.eventsphere.repository.EmailRepo;
import com.eventsphere.repository.UserRepo;
import com.eventsphere.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

//    @Autowired
//    private JavaMailSender mailSender;

    @Autowired
    private EmailRepo emailRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void sendEmail(String recipientEmail, String subject, String body) {

        /*
        try {
            // Sending email
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipientEmail);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);

            // Storing email details in the database
            User user = userRepository.findByEmail(recipientEmail)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            EmailNotification emailNotification = new EmailNotification();
            emailNotification.setRecipient(user);
            emailNotification.setSubject(subject);
            emailNotification.setBody(body);
            emailNotification.setSentAt(LocalDateTime.now());

            emailNotificationRepository.save(emailNotification);
        } catch (Exception e) {
            throw new RuntimeException("Error sending email: " + e.getMessage());
        }
*/
    }
}
