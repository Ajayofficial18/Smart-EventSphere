package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.ApplicationForm;
import com.eventsphere.entity.User;
import com.eventsphere.enums.ApplicationStatus;
import com.eventsphere.repository.ApplicationFormRepository;
import com.eventsphere.repository.UserRepository;
import com.eventsphere.services.ApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService {

    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String submitApplication(ApplicationForm applicationForm) {
        applicationForm.setStatus(ApplicationStatus.PENDING);
        applicationForm.setSubmittedAt(LocalDateTime.now());
        applicationFormRepository.save(applicationForm);
        return "Application submitted successfully!";
    }

    @Override
    public String reviewApplication(Long applicationId, boolean approved) {
        ApplicationForm application = applicationFormRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        if (approved) {
            application.setStatus(ApplicationStatus.ACCEPTED);
        } else {
            application.setStatus(ApplicationStatus.REJECTED);
        }

        applicationFormRepository.save(application);
        return approved ? "Application ACCEPTED!" : "Application REJECTED!";
    }

    @Override
    public List<ApplicationForm> getPendingApplications() {
        return applicationFormRepository.findByStatus(ApplicationStatus.PENDING);
    }
}
