package com.e_commerce.auth_service.registration.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RegistrationConfiguration {

    @Bean
    RegistrationApi registrationApi(final RegistrationRepository registrationRepository){
        return new RegistrationApiImpl(registrationRepository);
    }
}
