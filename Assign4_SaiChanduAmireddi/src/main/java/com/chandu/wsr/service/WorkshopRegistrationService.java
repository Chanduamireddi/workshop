package com.chandu.wsr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandu.wsr.model.WorkshopRegistration;
import com.chandu.wsr.repository.WorkshopRegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopRegistrationService {

    @Autowired
    private WorkshopRegistrationRepository repository;

    public List<WorkshopRegistration> getAllRegistrations() {
        return repository.findAll();
    }

    public String saveDetails(WorkshopRegistration registration) {
        Optional<WorkshopRegistration> existingByEmail = repository.findByEmail(registration.getEmail());
        Optional<WorkshopRegistration> existingByPhone = repository.findByPhoneNumber(registration.getPhoneNumber());

        if (existingByEmail.isPresent()) {
            return "Email already used. Please use a different email.";
        }

        if (existingByPhone.isPresent()) {
            return "Phone number is taken. Please use a different number.";
        }

        repository.save(registration);
        return "Success";
    }

}
