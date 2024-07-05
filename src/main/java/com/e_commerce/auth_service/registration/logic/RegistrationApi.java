package com.e_commerce.auth_service.registration.logic;

import com.e_commerce.auth_service.registration.model.RegistrationDataRequest;
import com.e_commerce.auth_service.registration.model.RegistrationResponse;

public interface RegistrationApi {

    void processRegistration(RegistrationDataRequest request);
}
