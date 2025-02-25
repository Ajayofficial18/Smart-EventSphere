package com.eventsphere.services;

import com.eventsphere.entity.ApplicationForm;

import java.util.List;

public interface ApplicationFormService {
    String submitApplication(ApplicationForm applicationForm);
    String reviewApplication(Long applicationId, boolean approved);
    List<ApplicationForm> getPendingApplications();
}
