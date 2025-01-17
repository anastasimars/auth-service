package com.e_commerce.auth_service.registration.logic;

import com.e_commerce.auth_service.registration.model.ActiveUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface RegistrationRepository extends JpaRepository<ActiveUserEntity, Long> {
}
