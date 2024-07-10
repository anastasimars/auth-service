package com.e_commerce.auth_service.registration.logic;

import com.e_commerce.auth_service.registration.model.RegistrationRequest;

public interface RegistrationApi {

    void processRegistration(RegistrationRequest request);
}
