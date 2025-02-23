package com.chandu.wsr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandu.wsr.model.WorkshopRegistration;

import java.util.Optional;

public interface WorkshopRegistrationRepository extends JpaRepository<WorkshopRegistration, Long> {
    Optional<WorkshopRegistration> findByEmail(String email);
    Optional<WorkshopRegistration> findByPhoneNumber(String phoneNumber);
}
