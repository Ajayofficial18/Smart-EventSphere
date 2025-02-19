package com.eventsphere.repository;

import com.eventsphere.entity.ApplicationForm;
import com.eventsphere.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {

    List<ApplicationForm> findByStatus(ApplicationStatus status);
}
